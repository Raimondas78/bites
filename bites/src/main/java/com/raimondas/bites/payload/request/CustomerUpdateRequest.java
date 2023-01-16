package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.CustomerCode;

public class CustomerUpdateRequest extends CustomerRequest {

    private long id;

    @JsonCreator
    public CustomerUpdateRequest(@JsonProperty("id") long id,
                                 @JsonProperty("name") String name,
                                 @JsonProperty("surname") String surname,
                                 @JsonProperty("address") String address,
                                 @JsonProperty("customerCode") CustomerCode customerCode) {
        super(name, surname, address, customerCode);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
