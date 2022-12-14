package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank(message = "Customer's name cannot be blank")
    private final String name;

    @NotBlank(message = "Customer's surname cannot be blank")
    private final String surname;

    @NotBlank
    private final String personalCode;

    private final String companyCode;

    private final String companyName;

    @NotBlank(message = "Customer's address cannot be blank")
    private final String address;

    @JsonCreator
    public CustomerRequest(@JsonProperty("name") String name, @JsonProperty("surname") String surname,
                           @JsonProperty("personalCode") String personalCode,
                           @JsonProperty("companyName") String companyName,
                           @JsonProperty("companyCode") String companyCode,
                           @JsonProperty("address") String address) {
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
        this.companyCode = companyCode;
        this.companyName = companyName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Customer asCustomer() {
        return new Customer(name, surname, personalCode, companyName, companyCode,  address);
    }
}
