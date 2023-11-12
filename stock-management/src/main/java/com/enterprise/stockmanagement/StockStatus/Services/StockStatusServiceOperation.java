package com.enterprise.stockmanagement.StockStatus.Services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Service.INFO.MovementINFOService;
import com.enterprise.stockmanagement.Movement.Service.operation.MovementOperationService;

@Service
public class StockStatusServiceOperation {
    
    @Autowired MovementINFOService movementINFOService ;

    @Autowired MovementOperationService movementOperationService ;

    public Double getStockStatusQuantity(Timestamp date)
    {
        // get last report before the date
        Timestamp reportDate =  movementINFOService.getLastReportDate(date) ;

        if (reportDate == null) 
        {
            // get all movement before the date for the sum operation
            List<Movement> list  = movementINFOService.getAllButReportingWithDateMovementInferiorTo(date) ;
            Movement[] movements = list.toArray(new Movement[list.size()]) ;

            // return the final sum
            return  movementOperationService.sumAllQuantity(movements) ;

        }
        else{
            // get all movement before the date and last report date for the sum operation
            List<Movement> list  = movementINFOService.getAllWithDateMovementBetween( reportDate,date) ;
            Movement[] movements = list.toArray(new Movement[list.size()]) ;

            return movementOperationService.sumAllQuantityTimesPrice(movements) ;
        }
    }

}
