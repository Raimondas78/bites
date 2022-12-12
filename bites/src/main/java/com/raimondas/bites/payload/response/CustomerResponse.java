package com.raimondas.bites.payload.response;

import com.raimondas.bites.entity.Customer;

public class CustomerResponse {

    private long id;

    private String name;

    private String surname;

    private String companyName;

    private String companyCode;

    private String personalCode;

    private String address;

    public CustomerResponse(long id, String name, String surname, String personalCode, String address, String companyName, String companyCode) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.companyName = companyName;
        this.companyCode = companyCode;
        this.personalCode = personalCode;
        this.address = address;
    }

    public static CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(), customer.getPersonalCode(),
                customer.getAddress(), customer.getCompanyName(), customer.getCompanyCode());
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

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public String getAddress() {
        return address;
    }
}
