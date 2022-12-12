package com.raimondas.bites.service;

import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.payload.request.OrderedServiceUpdateRequest;
import com.raimondas.bites.payload.response.OrderedServicePageResponse;
import com.raimondas.bites.repository.OrderedServiceRepository;
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
        }
        return orderedServicePageResponse;
    }

    @Transactional
    public void createService(OrderedService orderedService) {
        orderedServiceRepository.save(orderedService);
    }

    @Transactional
    public void updateService(OrderedServiceUpdateRequest orderedServiceUpdateRequest) {
        orderedServiceRepository.updateOrderedService(
                orderedServiceUpdateRequest.getName(),
                orderedServiceUpdateRequest.getType(),
                orderedServiceUpdateRequest.getActiveFrom(),
                orderedServiceUpdateRequest.getActiveTo(),
                orderedServiceUpdateRequest.getDescription(),
                orderedServiceUpdateRequest.getId()
        );
    }


    public void deleteById(long id) {
        orderedServiceRepository.deleteById(id);
    }
}
