package com.raimondas.bites.service;

import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.exception.EntityNotFoundException;
import com.raimondas.bites.payload.request.OrderedServiceCreateRequest;
import com.raimondas.bites.payload.request.OrderedServiceUpdateRequest;
import com.raimondas.bites.payload.response.OrderedServicePageResponse;
import com.raimondas.bites.repository.CustomerRepository;
import com.raimondas.bites.repository.OrderedServiceRepository;
import com.raimondas.bites.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderedServiceService {

    @Autowired
    OrderedServiceRepository orderedServiceRepository;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ServiceRepository serviceRepository;

    public List<OrderedServicePageResponse> getAllOrderedServices() {
        List<OrderedService> services = new ArrayList<>();
        orderedServiceRepository.findAll().forEach(services::add);

        List<OrderedServicePageResponse> orderedServicePageResponses = services.stream().
                map(OrderedServicePageResponse::fromOrderedService).
                collect(Collectors.toList());
        return orderedServicePageResponses;
    }

    public OrderedServicePageResponse findById(long id) {
        Optional<OrderedService> optionalOrderedService = orderedServiceRepository.findById(id);
        OrderedServicePageResponse orderedServicePageResponse = null;
        if (optionalOrderedService.isPresent()) {
            OrderedService orderedService = optionalOrderedService.get();
            orderedServicePageResponse = OrderedServicePageResponse.fromOrderedService(orderedService);
        } else {
            throw new EntityNotFoundException("Ordered Service with provided id = " + id + " does not exist");
        }
        return orderedServicePageResponse;
    }

    public List<OrderedService> findByCustomerId(long id) {
        return orderedServiceRepository.findByCustomerId(id);
    }

    @Transactional
    public OrderedServicePageResponse createOrderedService(OrderedServiceCreateRequest orderedServiceCreateRequest) {

        Customer customer = customerService.findById((orderedServiceCreateRequest.getCustomerId())).
                orElseThrow(() -> new EntityNotFoundException("Customer with id " +
                        orderedServiceCreateRequest.getCustomerId() + " not found"));
        com.raimondas.bites.entity.Service service = serviceRepository.findById(orderedServiceCreateRequest.getServiceId())
                .orElseThrow(() -> new EntityNotFoundException("Service with id " +
                        orderedServiceCreateRequest.getServiceId() + " not found"));
        OrderedService orderedService = orderedServiceCreateRequest.asOrderedService(customer, service);
        OrderedService os = orderedServiceRepository.save(orderedService);
        return OrderedServicePageResponse.fromOrderedService(os);
    }

    @Transactional
    public void updateOrderedService(OrderedServiceUpdateRequest orderedServiceUpdateRequest) {
        Optional<OrderedService> orderedServiceOptional = orderedServiceRepository.findById(orderedServiceUpdateRequest.getId());
        if (orderedServiceOptional.isPresent()) {
            orderedServiceRepository.save(new OrderedService(
                    orderedServiceUpdateRequest.getId(),
                    orderedServiceUpdateRequest.getActiveFrom(),
                    orderedServiceUpdateRequest.getActiveTo(),
                    customerRepository.findById(orderedServiceUpdateRequest.getCustomerId()).orElseThrow(),
                    serviceRepository.findById(orderedServiceUpdateRequest.getServiceId()).orElseThrow()));
        } else {
            throw new EntityNotFoundException("Ordered Service with provided id " + orderedServiceUpdateRequest.getId() +
                    " does not exist");
        }
    }


    public void deleteById(long id) {

        Optional<OrderedService> optionalOrderedService = orderedServiceRepository.findById(id);
        if (optionalOrderedService.isPresent()) {
            orderedServiceRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Ordered Service provided with id = " + id + " does not exist");
        }
    }

    public List<OrderedServicePageResponse> findOrderedServicesByServiceId(long id) {
        List<OrderedService> orderedServices = orderedServiceRepository.findOrderedServicesByServiceId(id);
        List<OrderedServicePageResponse> orderedServicePageResponses = orderedServices.stream().
                map(OrderedServicePageResponse::fromOrderedService).
                collect(Collectors.toList());
        return orderedServicePageResponses;
    }
}
