package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderedServiceUpdateRequest extends OrderedServiceRequest {

    private final long id;
    private long serviceId;

    private long customerId;


    @JsonCreator
    public OrderedServiceUpdateRequest(@JsonProperty("id") long id,
                                       @JsonProperty("activeFrom") String activeFrom,
                                       @JsonProperty("activeTo") String activeTo, long customerId, long serviceId) {
        super(activeFrom, activeTo);
        this.id = id;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public long getId() {
        return id;
    }

    public long getServiceId() {
        return serviceId;
    }

    public long getCustomerId() {
        return serviceId;
    }
}
