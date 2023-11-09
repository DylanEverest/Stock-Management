package com.enterprise.stockmanagement.StockStatus.Models;

import org.springframework.stereotype.Component;

@Component
public class StockStatusModel extends FormStockStatusModel
{
    private Double finalQuantity;

    private Double initialQuantity ;




    public Double getFinalQuantity() 
    {
        return finalQuantity;
    }

    public void setFinalQuantity(Double finalQuantity) 
    {
        this.finalQuantity = finalQuantity;
    }

    public Double getInitialQuantity() 
    {
        return initialQuantity;
    }

    public void setInitialQuantity(Double initialQuantity) 
    {
        this.initialQuantity = initialQuantity;
    }
    
}
