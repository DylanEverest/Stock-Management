package com.enterprise.stockmanagement.Movement.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Movement.Entities.Movement;

@Repository
public interface MovementRepository extends JpaRepository< Movement,Integer>{
    
    List<Movement> findAllByMethodType (@Param("methodType") Integer methodType) ;
}
