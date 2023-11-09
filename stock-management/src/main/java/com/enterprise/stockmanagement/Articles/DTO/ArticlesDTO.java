package com.enterprise.stockmanagement.Articles.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

@Component
public class ArticlesDTO 
{
    @Autowired
    Articles [] listArticles ;    

    String errors ;

    @Autowired
    Articles articles ;

    public void setArticlesAsList(List<Articles> list)
    {
        listArticles = list.toArray(new Articles[list.size()]);
    }

    public Articles[] getListArticles() {
        return listArticles;
    }

    public void setListArticles(Articles[] listArticles) {
        this.listArticles = listArticles;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Articles getArticles() {
        return articles;
    }

    public void setArticles(Articles articles) {
        this.articles = articles;
    }


}
