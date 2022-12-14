package com.raimondas.bites.repository;


import com.raimondas.bites.entity.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Modifying
    @Query("UPDATE Customer c SET c.name = :name, c.surname = :surname, c.personalCode = :personalCode, " +
            "c.address = :address, c.companyName = :companyName, " +
            "c.companyCode = :companyCode WHERE c.id = :id")
    void updateCustomer(String name, String surname, String personalCode, String address, String companyName,
                        String companyCode, long id);


}
