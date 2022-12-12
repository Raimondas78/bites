package com.raimondas.bites.payload.response;

import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;

import java.time.LocalDate;

public class OrderedServicePageResponse extends OrderedServiceResponse {

    private Customer customer;

    public OrderedServicePageResponse(long id, String name, String type,
                                      LocalDate activeFrom, LocalDate activeTo, Customer customer, String description) {
        super(id, name, type, activeFrom, activeTo, description);
        this.customer = customer;
    }

    public static OrderedServicePageResponse fromOrderedService(OrderedService orderedService) {
        return new OrderedServicePageResponse(
                orderedService.getId(),
                orderedService.getName(),
                orderedService.getType().getLabel(),
                orderedService.getActiveFrom(),
                orderedService.getActiveTo(),
                orderedService.getCustomer(),
                orderedService.getDescription()
        );
    }
}
