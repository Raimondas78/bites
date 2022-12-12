package com.raimondas.bites.repository;


import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface OrderedServiceRepository extends CrudRepository<OrderedService, Long> {

    @Modifying
    @Query("UPDATE OrderedService SET name = ?1, type = ?2, activeFrom = ?3, activeTo = ?4, " +
            "description = ?5  WHERE id = ?6")
    void updateOrderedService(String name, String type, LocalDate activeFrom, LocalDate activeTo,
                              String description, long id);
}
