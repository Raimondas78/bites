package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderedServiceUpdateRequest extends OrderedServiceRequest {

    private final long id;


    @JsonCreator
    public OrderedServiceUpdateRequest(@JsonProperty("id") long id,
                                       @JsonProperty("name") String name,
                                       @JsonProperty("type") String type,
                                       @JsonProperty("activeFrom") String activeFrom,
                                       @JsonProperty("activeTo") String activeTo,
                                       @JsonProperty("description") String description) {
        super(name, type, activeFrom, activeTo, description);
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
