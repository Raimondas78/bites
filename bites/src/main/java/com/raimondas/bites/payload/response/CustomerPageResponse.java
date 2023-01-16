package com.raimondas.bites.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.CustomerCode;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerPageResponse extends CustomerResponse {

    private final List<OrderedServicePageResponse> orderedServices;

    public CustomerPageResponse(@JsonProperty long id,
                                @JsonProperty String name,
                                @JsonProperty String surname,
                                @JsonProperty String address,
                                @JsonProperty CustomerCode customerCode,
                                @JsonProperty List<OrderedServicePageResponse> orderedServices) {
                super(id, name, surname, address, customerCode);

        this.orderedServices = orderedServices;
    }

    public static CustomerPageResponse fromCustomer(Customer customer) {
        List<OrderedServicePageResponse> orderedServices = customer.getOrderedServices().stream().
                map(OrderedServicePageResponse::fromOrderedService).
                collect(Collectors.toList());
        return new CustomerPageResponse(
                customer.getId(),
                customer.getName(),
                customer.getSurname(),
                customer.getAddress(),
                customer.getCustomerCode(),
                orderedServices
        );
    }

    public List<OrderedServicePageResponse> getOrderedServices() {
        return orderedServices;
    }
}
