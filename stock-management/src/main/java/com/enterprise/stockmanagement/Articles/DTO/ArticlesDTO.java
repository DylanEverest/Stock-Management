package com.enterprise.stockmanagement.Articles.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

@Component
public class ArticlesDTO 
{
    @Autowired
    Articles [] articles ;    

    String errors ;

    public Articles[] getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles[0] = articles;
    }
    public void setArticles(Articles[] articles) {
        this.articles = articles;
    }
    public void setArticles(List<Articles> articles) {
        this.articles = articles.toArray(new Articles[articles.size()]);
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
