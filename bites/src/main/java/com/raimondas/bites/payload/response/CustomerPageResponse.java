package com.raimondas.bites.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raimondas.bites.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerPageResponse extends CustomerResponse {

    private final List<OrderedServiceResponse> orderedServices;

    public CustomerPageResponse(@JsonProperty long id, @JsonProperty String name, @JsonProperty String surname,
                                @JsonProperty String companyName, @JsonProperty String companyCode,
                                @JsonProperty String personalCode, @JsonProperty String address,
                                @JsonProperty List<OrderedServiceResponse> orderedServices) {
        super(id, name, surname, companyName, companyCode, personalCode, address);
        this.orderedServices = orderedServices;
    }

    public static CustomerPageResponse fromCustomer(Customer customer) {
        List<OrderedServiceResponse> orderedServices = customer.getOrderedServices().stream().
                map(OrderedServiceResponse::fromOrderedService).
                collect(Collectors.toList());
        return new CustomerPageResponse(
                customer.getId(), customer.getName(), customer.getSurname(), customer.getPersonalCode(), customer.getAddress(),
                customer.getCompanyName(),
                customer.getCompanyCode(), orderedServices
        );
    }

    public List<OrderedServiceResponse> getOrderedServices() {
        return orderedServices;
    }
}
