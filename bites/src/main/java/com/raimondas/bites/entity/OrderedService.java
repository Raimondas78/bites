package com.raimondas.bites.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table
public class OrderedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;


    private Type type;

    @Column
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate activeFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate activeTo;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public OrderedService() {
    }

    public OrderedService(String name, Type type, LocalDate activeFrom, LocalDate activeTo, Customer customer, String description) {
        this.name = name;
        this.type = type;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
        this.customer = customer;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getActiveFrom() {
        return activeFrom;
    }

    public LocalDate getActiveTo() {
        return activeTo;
    }

    public Customer getCustomer() {
        return customer;
    }

}
