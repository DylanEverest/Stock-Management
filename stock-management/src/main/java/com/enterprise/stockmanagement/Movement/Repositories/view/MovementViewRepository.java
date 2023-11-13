package com.enterprise.stockmanagement.Movement.Repositories.view;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Movement.Entities.view.MovementView;

@Repository
public interface MovementViewRepository extends JpaRepository< MovementView,Integer>{
 
    List<MovementView> findAllByMethodType (@Param("methodType") Integer methodType) ;


    @Query(value =  "SELECT * FROM movementview WHERE date_movement <= :date and method_type != 3 and family like :family% and store_name = :store",nativeQuery=true)
    List<MovementView> findAllButReportingWithDateMovementInferiorOrEqualTo(@Param("date") Timestamp date , @Param("family") String family ,@Param("store") String store) ;

    @Query(value = "SELECT max(date_movement) FROM movementview WHERE date_movement < :date and method_type = 3 and family like :family% and store_name = :store"
    , nativeQuery = true)
    Optional<Timestamp> findLastReportDate(     @Param("date") Timestamp date , 
                                                @Param("family") String family ,
                                                @Param("store") String store);


    @Query( value =  "SELECT * FROM movementview WHERE :date1 <= date_movement AND date_movement< :date2 and family like :family% and store_name = :store",
            nativeQuery=true)
    List<MovementView> findAllWithDateMovementBetween(  @Param("date1") Timestamp date, 
                                                        @Param("date2") Timestamp date2 , 
                                                        @Param("family") String family ,@Param("store") String store ) ;


    @Query( value =  "SELECT * FROM movementview WHERE :date1 < date_movement AND date_movement< :date2 and family like :family% and store_name = :store",
            nativeQuery=true)
    List<MovementView> findAllWithDateMovementBetweenWithClosedInterval(  @Param("date1") Timestamp date, 
                                                    @Param("date2") Timestamp date2 , 
                                                    @Param("family") String family ,@Param("store") String store ) ;
                                                    
}
