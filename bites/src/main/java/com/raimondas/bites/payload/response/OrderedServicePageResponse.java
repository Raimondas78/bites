package com.raimondas.bites.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.OrderedService;

import java.time.LocalDate;

public class OrderedServicePageResponse extends OrderedServiceResponse {

    private final long customer;
    private final long service;

    public OrderedServicePageResponse(@JsonProperty("id") long id,
                                      @JsonProperty("activeFrom") LocalDate activeFrom,
                                      @JsonProperty("activeTo") LocalDate activeTo,
                                      long customer, long service) {
        super(id, activeFrom, activeTo);
        this.customer = customer;
        this.service = service;
    }

    public static OrderedServicePageResponse fromOrderedService(OrderedService orderedService) {

        OrderedServicePageResponse orderedServicePageResponse = new OrderedServicePageResponse(
                orderedService.getId(),
                orderedService.getActiveFrom(),
                orderedService.getActiveTo(),
                orderedService.getCustomer().getId(),
                orderedService.getService().getId()
        );
        return orderedServicePageResponse;
    }

    public long getCustomer() {
        return customer;
    }

    public long getService() {
        return service;
    }
}
