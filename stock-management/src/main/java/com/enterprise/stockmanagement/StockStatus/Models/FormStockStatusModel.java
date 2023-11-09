package com.enterprise.stockmanagement.StockStatus.Models;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.NotSuccessiveDate;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.Exception.DateUnvalidExcetion;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampValidation;
import com.enterprise.stockmanagement.Store.Entities.Store;

@Component
public class FormStockStatusModel 
{
    private Timestamp beginDate;

    private Timestamp endDate;

    private Articles article ;
    
    private Store store;


    public Timestamp getBeginDate() {
        return beginDate;
    }

    // controll
    public void setBeginDateAndSetEndDate(String beginDate , String endDate) throws DateUnvalidExcetion, NotSuccessiveDate 
    {
        TimestampValidation validation = new TimestampValidation();

        Timestamp timestamp1 = validation.isValid(beginDate);
        Timestamp timestamp2 = validation.isValid(endDate);

        validation.checkSuccessive(timestamp1,timestamp2);

        setBeginDate(timestamp1);
        setEndDate(timestamp2);
    }

    private void setBeginDate(Timestamp beginDate) {

        this.beginDate = beginDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Articles getArticle() {
        return article;
    }

    public void setArticle(Articles article) {
        this.article = article;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    
}
