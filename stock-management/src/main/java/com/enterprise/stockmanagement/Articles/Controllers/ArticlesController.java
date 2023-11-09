package com.enterprise.stockmanagement.Articles.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.Articles.DTO.ArticlesDTO;
import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.Articles.Services.CRUDArticles;

@RestController
@RequestMapping("/StockApplication")
public class ArticlesController 
{

    @Autowired
    private CRUDArticles crudArticles ;

    @Autowired
    private ArticlesDTO articlesDTO ;


    @GetMapping(path = "/articles")
    public ArticlesDTO getArticless()
    {
        List<Articles> articles = crudArticles.getArticlesList() ;
        articlesDTO.setArticlesAsList(articles);
        return articlesDTO ;
    }

    @GetMapping(path = "/articles/{id}")
    public ArticlesDTO getArticlessById(@PathVariable("id") final Integer id)
    {
        Articles articles = crudArticles.getArticlesByID(Integer.valueOf(id)) ;
        articlesDTO.setArticles(articles) ;

        return articlesDTO ;
    }

    @PostMapping(path = "/articles")
    public ArticlesDTO saveArticles(@RequestBody ArticlesDTO articlesDTO)
    {
        crudArticles.postArticles(articlesDTO.getArticles());

        return articlesDTO;

    }    

    @PutMapping(path ="/articles/{id}")
    public ArticlesDTO updateArticles(@PathVariable("id") final Integer id , @RequestBody ArticlesDTO articlesDTO)
    {
        crudArticles.updateArticles(id, articlesDTO.getArticles());

        return articlesDTO;
    }

    @DeleteMapping(path = "/articles/{id}")
    public void deleteArticles(@PathVariable("id") final Integer id)
    {
        crudArticles.deleteArticlesByID(id);
    }
    
    
}
