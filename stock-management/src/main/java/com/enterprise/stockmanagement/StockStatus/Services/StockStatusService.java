package com.enterprise.stockmanagement.StockStatus.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.StockStatus.Models.StockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.FormStockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.ArticlesNotFoundException;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.StoreNotFoundException;

@Service
public class StockStatusService 
{

    @Autowired StockStatusServiceOperation stockStatusServiceOperation ;

    public StockStatusModel getStockStatus(FormStockStatusModel formStockStatusModel) throws ArticlesNotFoundException, StoreNotFoundException {
        
        StockStatusModel stockStatusModel = new StockStatusModel() ;

        stockStatusModel.setInitialQuantity(stockStatusServiceOperation.getStockStatusQuantity(formStockStatusModel.getBeginDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        stockStatusModel.setFinalQuantity(stockStatusServiceOperation.getStockStatusQuantity(formStockStatusModel.getEndDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        stockStatusModel.setPriceValue(stockStatusServiceOperation.getStockStatusPriceValue(formStockStatusModel.getEndDate() ,formStockStatusModel.getArticle() , formStockStatusModel.getStore()));

        stockStatusModel.setArticle(formStockStatusModel.getArticle());

        stockStatusModel.setBeginDate(formStockStatusModel.getBeginDate());

        stockStatusModel.setEndDate(formStockStatusModel.getEndDate());

        stockStatusModel.setStore(formStockStatusModel.getStore());


        return stockStatusModel ;
    }


}
