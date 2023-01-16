package com.raimondas.bites.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class OrderedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate activeFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate activeTo;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    public OrderedService() {
    }

    public OrderedService(LocalDate activeFrom, LocalDate activeTo, Customer customer, Service service) {
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
        this.customer = customer;
        this.service = service;
    }

    public OrderedService(long id, LocalDate activeFrom, LocalDate activeTo, Customer customer, Service service) {
        this.id = id;
        this.activeFrom = activeFrom;
        this.activeTo = activeTo;
        this.customer = customer;
        this.service = service;
    }

    public long getId() {
        return id;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderedService)) return false;
        OrderedService that = (OrderedService) o;
        return getId() == that.getId() && getActiveFrom().equals(that.getActiveFrom()) && getActiveTo().equals(that.getActiveTo()) && getCustomer().equals(that.getCustomer()) && getService().equals(that.getService());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getActiveFrom(), getActiveTo(), getCustomer(), getService());
    }

    @Override
    public String toString() {
        return "OrderedService{" +
                "id=" + id +
                ", activeFrom=" + activeFrom +
                ", activeTo=" + activeTo +
                ", customer=" + customer +
                ", service=" + service +
                '}';
    }
}
