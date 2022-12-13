package com.raimondas.bites.payload.response;

import com.raimondas.bites.entity.OrderedService;

import java.time.LocalDate;

public class OrderedServiceResponse {

    private long id;

    private String name;

    private String type;

    private String description;

    private LocalDate activeFrom;

    private LocalDate activeTo;

    public OrderedServiceResponse(long id, String name, String type, LocalDate activeFrom, LocalDate activeTo,
                                  String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
    }

    public static OrderedServiceResponse fromOrderedService(OrderedService orderedService) {
        return new OrderedServiceResponse(
                orderedService.getId(),
                orderedService.getName(),
                orderedService.getType().getLabel(),
                orderedService.getActiveFrom(),
                orderedService.getActiveTo(),
                orderedService.getDescription()
        );
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }
}
