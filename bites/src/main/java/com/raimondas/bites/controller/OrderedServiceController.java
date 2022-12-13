package com.raimondas.bites.controller;

import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.payload.request.OrderedServiceCreateRequest;
import com.raimondas.bites.payload.request.OrderedServiceUpdateRequest;
import com.raimondas.bites.payload.response.OrderedServicePageResponse;
import com.raimondas.bites.service.CustomerService;
import com.raimondas.bites.service.OrderedServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderedServiceController {

    OrderedServiceService service;

    CustomerService customerService;

    @Autowired
    public OrderedServiceController(OrderedServiceService service, CustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
    }

    @GetMapping("/service")
    public List<OrderedServicePageResponse> getAllServices() {
        return service.getAllOrderedServices();
    }

    @GetMapping("/service/{id}")
    public OrderedServicePageResponse getService(@PathVariable("id") long id) {
        OrderedServicePageResponse orderedServicePageResponse = service.findById(id);
        if (orderedServicePageResponse == null) {
            throw new RuntimeException("Ordered Service with id = " + id + " does not exist");
        }
        return orderedServicePageResponse;
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable("id") long id) {
        service.deleteById(id);
    }

    @PostMapping("/service")
    public void createService(@RequestBody OrderedServiceCreateRequest orderedServiceCreateRequest) {
        Customer customer = customerService.findById((orderedServiceCreateRequest.getCustomerId())).
                orElseThrow(() -> new RuntimeException("Customer id not found"));
        OrderedService orderedService = orderedServiceCreateRequest.asOrderedService(customer);
        service.createService(orderedService);
    }

    @PutMapping("/service")
    public void updateService(@RequestBody @Valid OrderedServiceUpdateRequest orderedServiceUpdateRequest) {
        service.updateService(orderedServiceUpdateRequest);
    }

}
