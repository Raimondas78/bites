package com.raimondas.bites.repository;


import com.raimondas.bites.entity.OrderedService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderedServiceRepository extends CrudRepository<OrderedService, Long> {

    @Modifying
    @Query("Select ser From OrderedService ser Where customer.id = ?1 ")
    List<OrderedService> findByCustomerId(long id);

    @Modifying
    @Query("Select ser From OrderedService ser Where service.id = ?1 ")
    List<OrderedService> findOrderedServicesByServiceId(long id);
}
