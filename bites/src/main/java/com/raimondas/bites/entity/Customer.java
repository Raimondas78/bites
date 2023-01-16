package com.raimondas.bites.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerCode_id", referencedColumnName = "id")
    private CustomerCode customerCode;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderedService> orderedServices = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String surname, String address, CustomerCode customerCode) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.customerCode = customerCode;
    }

    public Customer(long id, String name, String surname, CustomerCode customerCode, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.customerCode = customerCode;
        this.address = address;
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

    public List<OrderedService> getOrderedServices() {
        return orderedServices;
    }

    public CustomerCode getCustomerCode() {
        return customerCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() && getName().equals(customer.getName()) && getSurname().equals(customer.getSurname()) && getCustomerCode().equals(customer.getCustomerCode()) && getAddress().equals(customer.getAddress()) && getOrderedServices().equals(customer.getOrderedServices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getCustomerCode(), getAddress(), getOrderedServices());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", customerCode=" + customerCode +
                ", address='" + address + '\'' +
                ", orderedServices=" + orderedServices +
                '}';
    }
}
