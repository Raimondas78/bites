package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.entity.Type;


public class OrderedServiceCreateRequest extends OrderedServiceRequest {

    private long customerId;

    @JsonCreator
    public OrderedServiceCreateRequest(@JsonProperty("name") String name, @JsonProperty("type") String type,
                                       @JsonProperty("activeFrom") String activeFrom,
                                       @JsonProperty("activeTo") String activeTo,
                                       @JsonProperty("description") String description, long customerId) {
        super(name, type, activeFrom, activeTo, description);
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public OrderedService asOrderedService(Customer customer) {
        return new OrderedService(getName(), Type.valueOf(getType()), getActiveFrom(), getActiveTo(),
                customer, getDescription());
    }
}
