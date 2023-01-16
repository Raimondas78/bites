package com.raimondas.bites.payload.response;

import com.raimondas.bites.entity.OrderedService;

import java.time.LocalDate;

public class OrderedServiceResponse {

    private long id;

    private LocalDate activeFrom;

    private LocalDate activeTo;

    public OrderedServiceResponse(long id, LocalDate activeFrom, LocalDate activeTo) {
        this.id = id;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
    }

    public static OrderedServiceResponse fromOrderedService(OrderedService orderedService) {
        return new OrderedServiceResponse(
                orderedService.getId(),
                orderedService.getActiveFrom(),
                orderedService.getActiveTo()
        );
    }

    public long getId() {
        return id;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }
}
