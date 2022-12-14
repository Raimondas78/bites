package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerUpdateRequest extends CustomerRequest {

    private long id;

    @JsonCreator
    public CustomerUpdateRequest(@JsonProperty("id") long id,
                                 @JsonProperty("name") String name,
                                 @JsonProperty("surname") String surname,
                                 @JsonProperty("personalCode") String personalCode,
                                 @JsonProperty("address") String address,
                                 @JsonProperty("companyName") String companyName,
                                 @JsonProperty("companyCode") String companyCode) {
        super(name, surname, personalCode, companyName, companyCode, address);
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
