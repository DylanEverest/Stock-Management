package com.enterprise.stockmanagement.Articles.DTO;

import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

@Component
public class ArticlesDTO 
{
    
    Articles [] articles ;    

    String errors ;

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
