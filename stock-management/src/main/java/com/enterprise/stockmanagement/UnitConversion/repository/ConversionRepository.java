package com.enterprise.stockmanagement.UnitConversion.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enterprise.stockmanagement.UnitConversion.entity.Conversion;

public interface ConversionRepository extends JpaRepository<Conversion,Integer>{


    @Query(value = "select factor from conversion where unit_destination_unit_id = :dest and unit_source_unit_id = :source "
           , nativeQuery = true)
    Double findFactor(@Param("dest") Integer unit_destination_unit_id ,@Param("source") Integer source_unit_id) ;
    
}
