package com.enterprise.stockmanagement.UnitConversion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.stockmanagement.UnitConversion.entity.Conversion;

public interface ConversionRepository extends JpaRepository<Conversion,Integer>{
    
}
