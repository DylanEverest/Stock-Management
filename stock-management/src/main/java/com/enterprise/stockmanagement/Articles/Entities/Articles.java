package com.enterprise.stockmanagement.Articles.Entities;

import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.UnitConversion.entity.Unit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "Articles")
public class Articles 
{

    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articlesID ;

    @Column(length=250,nullable =  false) 
    private String family ;   

    @Column(length = 250 ,nullable = false, unique = true)
    private String nameArticles ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private MethodType methodType ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private Unit unit ;



    public Integer getArticlesID() {
        return articlesID;
    }

    public void setArticlesID(Integer articlesID) {
        this.articlesID = articlesID;
    }

    public String getNameArticles() {
        return nameArticles;
    }

    public void setNameArticles(String nameArticles) {
        this.nameArticles = nameArticles;
    }

    public MethodType getMethodType() {
        return methodType;
    }

    public void setMethodType(MethodType methodType) {
        this.methodType = methodType;
    }
    
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
}
