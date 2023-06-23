package com.example.demo.daoimpl.repository;

import com.example.demo.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ManagerRepository")
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    Long deleteByName(String name);



//    Long deleteByNameAndDescription(String name, String description);
//
    Manager findByName(String name);

    //    @Query("SELECT distinct m FROM manager as m left join fetch m.clients as client left join fetch client.products where m.id = :id")
//    Manager findManagerWithClientsAndProductsByManagerId(@Param(value = "id") Long managerId);


}
