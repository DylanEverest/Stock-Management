package com.enterprise.stockmanagement.Movement.Repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Movement.Entities.Movement;

@Repository
public interface MovementRepository extends JpaRepository< Movement,Integer>{
    
    List<Movement> findAllByMethodType (@Param("methodType") Integer methodType) ;


    @Query(value =  "SELECT * FROM MOVEMENT WHERE date_movement < :date and method_type != 3",nativeQuery=true)
    List<Movement> findAllButReportingWithDateMovementInferiorOrEqualTo(@Param("date") Timestamp date) ;

    @Query(value = "SELECT max(date_movement) FROM MOVEMENT WHERE date_movement < :date and method_type = 3 "
    , nativeQuery = true)
    Optional<Timestamp> findLastReportDate(@Param("date") Timestamp date);


    @Query( value =  "SELECT * FROM MOVEMENT WHERE :date1 <= date_movement AND date_movement< :date2",
            nativeQuery=true)
    List<Movement> findAllWithDateMovementBetween(  @Param("date1") Timestamp date, 
                                                    @Param("date2") Timestamp date2 ) ;


    @Query( value =  "SELECT * FROM MOVEMENT WHERE :date1 < date_movement AND date_movement< :date2",
            nativeQuery=true)
    List<Movement> findAllWithDateMovementBetweenWithClosedInterval(  @Param("date1") Timestamp date, 
                                                    @Param("date2") Timestamp date2 ) ;


}
