package com.enterprise.stockmanagement.Articles.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Articles")
public class Articles 
{

    @Id   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String articlesID ;

    @Column(length=250,nullable =  false) 
    private String family ;   

    @Column(length = 250 ,nullable = false)
    private String nameArticles ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private MethodType methodType ;



    public String getArticlesID() {
        return articlesID;
    }

    public void setArticlesID(String articlesID) {
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
}
