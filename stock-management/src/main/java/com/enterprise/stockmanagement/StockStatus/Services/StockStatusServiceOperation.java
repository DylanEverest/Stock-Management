package com.enterprise.stockmanagement.StockStatus.Services;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.view.MovementView;
import com.enterprise.stockmanagement.Movement.Service.INFO.MovementINFOService;
import com.enterprise.stockmanagement.Movement.Service.operation.MovementOperationService;

@Service
public class StockStatusServiceOperation {
    
    @Autowired MovementINFOService movementINFOService ;

    @Autowired MovementOperationService movementOperationService ;

    public Double getStockStatusQuantity(Timestamp date ,String family , String store)
    {
        // get last report before the date
        Timestamp reportDate =  movementINFOService.getLastReportDate(date ,family ,store) ;

        if (reportDate == null) 
        {
            // get all movement before the date for the sum operation
            List<MovementView> list  = movementINFOService.getAllButReportingWithDateMovementInferiorOrEqualTo(date ,family ,store) ;
            MovementView[] movements = list.toArray(new MovementView[list.size()]) ;

            // return the final sum
            return  movementOperationService.sumAllQuantity(movements) ;

        }
        else{
            // get all movement before the date and last report date for the sum operation
            List<MovementView> list  = movementINFOService.getAllWithDateMovementBetween( reportDate,date,family ,store) ;
            MovementView[] movements = list.toArray(new MovementView[list.size()]) ;

            return movementOperationService.sumAllQuantityTimesPrice(movements) ;
        }
    }

    public Double getStockStatusPriceValue(Timestamp date ,String family , String store)
    {
        // get last report before the date
        Timestamp reportDate =  movementINFOService.getLastReportDate(date ,family ,store) ;

        if (reportDate == null) 
        {
            // get all movement before the date for the sum operation
            List<MovementView> list  = movementINFOService.getAllButReportingWithDateMovementInferiorOrEqualTo(date ,family ,store) ;
            MovementView[] movements = list.toArray(new MovementView[list.size()]) ;

            // return the final sum
            return  movementOperationService.sumAllQuantityTimesPrice(movements) ;

        }
        else{
            // get all movement before the date and last report date for the sum operation
            // List<MovementView> list  = movementINFOService.getAllWithDateMovementBetween( reportDate,date) ;
            // MovementView[] movements = list.toArray(new MovementView[list.size()]) ;

            // return movementOperationService.sumAllQuantityTimesPrice(movements) ;

            // for the moment
            return 0. ;
        }
    }

}
