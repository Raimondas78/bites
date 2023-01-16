package com.raimondas.bites.payload.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.CustomerCode;

import javax.validation.constraints.NotBlank;

public class CustomerRequest {

    @NotBlank(message = "Customer's name cannot be blank")
    private final String name;

    @NotBlank(message = "Customer's surname cannot be blank")
    private final String surname;

    private CustomerCode customerCode;

    @NotBlank(message = "Customer's address cannot be blank")
    private final String address;

    @JsonCreator
    public CustomerRequest(@JsonProperty("name") String name,
                           @JsonProperty("surname") String surname,
                           @JsonProperty("address") String address,
                           @JsonProperty("customerCode") CustomerCode customerCode) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.customerCode = customerCode;
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

    public CustomerCode getCustomerCode() {
        return customerCode;
    }

    public Customer asCustomer(CustomerCode customerCode) {

        return new Customer(name, surname, address, customerCode);
    }
}
