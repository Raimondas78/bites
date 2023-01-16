package com.raimondas.bites.payload.response;

import com.raimondas.bites.entity.Customer;
import com.raimondas.bites.entity.CustomerCode;

public class CustomerResponse {

    private long id;

    private String name;

    private String surname;

    private String address;

    private CustomerCode customerCode;


    public CustomerResponse(long id,
                            String name,
                            String surname,
                            String address,
                            CustomerCode customerCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.customerCode = customerCode;
    }

    public static CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(),
                customer.getAddress(), customer.getCustomerCode());
    }

    public long getId() {
        return id;
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
}
