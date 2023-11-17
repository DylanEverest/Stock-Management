package com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Repositories.ArticlesRepository;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.NotSuccessiveDate;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.Exception.DateUnvalidExcetion;
import com.enterprise.stockmanagement.DateValidation.Service.Timestamp.TimestampValidation;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.ArticlesNotFoundException;
import com.enterprise.stockmanagement.StockStatus.Models.FormStockStatusModel.Exception.StoreNotFoundException;
import com.enterprise.stockmanagement.Store.Repositories.StoreRepository;

@Component
public class FormStockStatusModel 
{
    private Timestamp beginDate;

    private Timestamp endDate;

    private String article ;
    
    private String store;

    @Autowired
    private ArticlesRepository articlesRepository ;

    @Autowired
    private StoreRepository storeRepository;

    public Timestamp getBeginDate() {
        return beginDate;
    }

    // controll
    public void setBeginDateAndSetEndDate(String beginDate , String endDate) throws DateUnvalidExcetion, NotSuccessiveDate 
    {
        TimestampValidation validation = new TimestampValidation();

        Timestamp timestamp1 = validation.isValid(beginDate);
        Timestamp timestamp2 = validation.isValid(endDate);

        validation.checkSuccessiveOrEqual(timestamp1,timestamp2);

        setBeginDate(timestamp1);
        setEndDate(timestamp2);
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

    public void setArticle(String article) throws ArticlesNotFoundException {

        if(!articlesRepository.existsFamily(article)) throw new ArticlesNotFoundException("Article " + article + " not found");

        this.article = article;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) throws StoreNotFoundException {

        if(!storeRepository.existsStoreName(store)) throw new StoreNotFoundException("Store " + store + " not found");

        this.store = store;
    }


    
}
