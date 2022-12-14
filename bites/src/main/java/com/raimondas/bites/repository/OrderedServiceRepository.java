package com.raimondas.bites.repository;


import com.raimondas.bites.entity.OrderedService;
import com.raimondas.bites.entity.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderedServiceRepository extends CrudRepository<OrderedService, Long> {

    @Modifying
    @Query("UPDATE OrderedService os SET os.name = :name, os.type = :type, os.activeFrom = :activeFrom, " +
            "os.activeTo = :activeTo, os.description = :description  WHERE os.id = :id")
    void updateOrderedService(String name, Type type, LocalDate activeFrom, LocalDate activeTo,
                              String description, long id);

    @Modifying
    @Query("Select ser From OrderedService ser Where customer.id = ?1 ")
    List<OrderedService> findByCustomerId(long id);
}
