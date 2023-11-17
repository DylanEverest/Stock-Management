package com.enterprise.stockmanagement.UnitConversion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.enterprise.stockmanagement.UnitConversion.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit,Integer>{


    Optional<Unit> findByName(@Param("name") String name) ;

}
