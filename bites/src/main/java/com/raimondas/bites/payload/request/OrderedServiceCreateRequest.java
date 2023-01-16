package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.entity.Service;

import javax.validation.constraints.NotNull;


public class OrderedServiceCreateRequest extends OrderedServiceRequest {

    @NotNull
    private final long customerId;

    @NotNull
    private final long serviceId;

    @JsonCreator
    public OrderedServiceCreateRequest(
            @JsonProperty("activeFrom") String activeFrom,
            @JsonProperty("activeTo") String activeTo,
            long customerId,
            long serviceId) {
        super(activeFrom, activeTo);
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public long getServiceId() {
        return serviceId;
    }

    public OrderedService asOrderedService(Customer customer, Service service) {
        return new OrderedService(getActiveFrom(), getActiveTo(),
                customer, service);
    }
}
