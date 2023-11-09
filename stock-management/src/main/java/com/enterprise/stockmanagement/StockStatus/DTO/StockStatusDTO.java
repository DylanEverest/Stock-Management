package com.enterprise.stockmanagement.StockStatus.DTO;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.StockStatus.Models.StockStatusModel;

@Component
public class StockStatusDTO {
    
    private Timestamp beginDate;

    private Timestamp endDate;

    private String article ;
    
    private String store;

    private Double finalQuantity;

    private Double initialQuantity ;

    private String errors ;


    public StockStatusDTO(StockStatusModel stockStatusModel) {

        setArticle(stockStatusModel.getArticle());
        setBeginDate(stockStatusModel.getBeginDate());
        setEndDate(stockStatusModel.getEndDate());
        setInitialQuantity(stockStatusModel.getInitialQuantity());
        setFinalQuantity(stockStatusModel.getFinalQuantity());

    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Double getFinalQuantity() {
        return finalQuantity;
    }

    public void setFinalQuantity(Double finalQuantity) {
        this.finalQuantity = finalQuantity;
    }

    public Double getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Double initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }


    
}
