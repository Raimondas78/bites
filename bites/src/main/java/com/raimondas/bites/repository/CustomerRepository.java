package com.raimondas.bites.repository;


import com.raimondas.bites.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
