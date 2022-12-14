package com.raimondas.bites.entity;

import com.raimondas.bites.entity.constraint.NumberConstraint;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @Column
    private String companyName;

    @Column
    private String companyCode;

    @Column(unique = true)
    @NumberConstraint
    private String personalCode;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderedService> orderedServices;

    public Customer() {
    }

    public Customer(String name, String surname, String personalCode, String companyName, String companyCode, String address) {
        this.name = name;
        this.surname = surname;
        this.personalCode = personalCode;
        this.address = address;
        this.companyName = companyName;
        this.companyCode = companyCode;
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

    public List<OrderedService> getOrderedServices() {
        return orderedServices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(companyName, customer.companyName) && Objects.equals(companyCode, customer.companyCode) && Objects.equals(personalCode, customer.personalCode) && Objects.equals(address, customer.address) && Objects.equals(orderedServices, customer.orderedServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, companyName, companyCode, personalCode, address, orderedServices);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyCode='" + companyCode + '\'' +
                ", personalCode='" + personalCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
