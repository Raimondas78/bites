package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.entity.Type;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class OrderedServiceRequest {

    @NotBlank(message = "Ordered service name must be present")
    private final String name;

    @NotBlank(message = "Ordered service type must be present")
    private final String type;

    @NotBlank(message = "Date service is active from must be present")
    private final LocalDate activeFrom;

    @NotBlank(message = "Date service is active till must be present")
    private final LocalDate activeTo;

    private final String description;

    public OrderedServiceRequest(@JsonProperty("name") String name, @JsonProperty("type") String type,
                                 @JsonProperty("activeFrom") String activeFrom,
                                 @JsonProperty("activeTo") String activeTo,
                                 @JsonProperty("description") String description) {
        this.name = name;
        this.type = type;
        this.activeFrom = LocalDate.parse(activeFrom);
        this.activeTo = LocalDate.parse(activeTo);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public String getDescription() {
        return description;
    }

    public OrderedService asOrderedService(Customer customer) {
        return new OrderedService(name, Type.valueOf(type), activeFrom, activeTo, customer, description);
    }

}
