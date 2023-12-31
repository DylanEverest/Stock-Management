package com.enterprise.stockmanagement.StockStatus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.StockStatus.DTO.FormStockStatusDTO;
import com.enterprise.stockmanagement.StockStatus.DTO.StockStatusDTO;
import com.enterprise.stockmanagement.StockStatus.Models.StockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.FormStockStatusModel;
import com.enterprise.stockmanagement.StockStatus.Services.StockStatusService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Autoriser les requêtes depuis ce domaine
public class StockStatusController 
{

    @Autowired
    StockStatusDTO stockStatusDTO;

    @Autowired
    FormStockStatusModel formStockStatusModel;

    @Autowired 
    StockStatusService stockStatusService;

    @PostMapping("/stockStatus")
    public StockStatusDTO getStockStatus(@RequestBody FormStockStatusDTO formStatusDTO) 
    {

        try 
        {
            formStockStatusModel.setArticle(formStatusDTO.getArticle());
            formStockStatusModel.setBeginDateAndSetEndDate(formStatusDTO.getBeginDate(),formStatusDTO.getEndDate());
            formStockStatusModel.setStore(formStatusDTO.getStore());

            StockStatusModel stockStatusModel = stockStatusService.getStockStatus(formStockStatusModel) ;

            stockStatusDTO = new StockStatusDTO(stockStatusModel) ;

        } 
        catch (Exception e) 
        {
            stockStatusDTO.setErrors(e.getMessage());
        }

        return stockStatusDTO;
    }    
    
}
