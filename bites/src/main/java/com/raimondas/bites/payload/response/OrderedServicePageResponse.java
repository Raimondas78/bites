package com.raimondas.bites.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.OrderedService;

import java.time.LocalDate;

public class OrderedServicePageResponse extends OrderedServiceResponse {

    private final long customer;

    public OrderedServicePageResponse(@JsonProperty("id") long id,
                                      @JsonProperty("name") String name,
                                      @JsonProperty("type") String type,
                                      @JsonProperty("activeFrom") LocalDate activeFrom,
                                      @JsonProperty("activeTo") LocalDate activeTo,
                                      @JsonProperty("description") String description,
                                      long customer) {
        super(id, name, type, activeFrom, activeTo, description);
        this.customer = customer;
    }

    public static OrderedServicePageResponse fromOrderedService(OrderedService orderedService) {

        OrderedServicePageResponse orderedServicePageResponse = new OrderedServicePageResponse(
                orderedService.getId(),
                orderedService.getName(),
                orderedService.getType().getLabel(),
                orderedService.getActiveFrom(),
                orderedService.getActiveTo(),
                orderedService.getDescription(),
                orderedService.getCustomer().getId()
        );
        return orderedServicePageResponse;
    }

    public long getCustomer() {
        return customer;
    }
}
