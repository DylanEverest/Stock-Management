package com.enterprise.stockmanagement.UnitConversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.stockmanagement.UnitConversion.entity.Unit;

public interface UnitRepository extends JpaRepository<Unit,Integer>{
    
}
