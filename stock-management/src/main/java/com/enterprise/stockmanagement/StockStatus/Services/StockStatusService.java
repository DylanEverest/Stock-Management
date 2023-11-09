package com.enterprise.stockmanagement.StockStatus.Services;

import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.StockStatus.Models.StockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.FormStockStatusModel;

@Service
public class StockStatusService 
{

    public StockStatusModel getStockStatus(FormStockStatusModel formStockStatusModel) {
        
        // for the moment
        return new StockStatusModel() ;
    }


}
