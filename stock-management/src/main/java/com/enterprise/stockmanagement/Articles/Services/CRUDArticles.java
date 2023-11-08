package com.enterprise.stockmanagement.Articles.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Articles.Entities.Articles;
import com.enterprise.stockmanagement.Articles.Repositories.ArticlesRepository;
import com.enterprise.stockmanagement.Articles.Services.Exception.ArticleFamilyNotFoundException;

@Service
public class CRUDArticles 
{

    @Autowired
    ArticlesRepository articlesRepository ;

    public List<Articles> getArticlesList() 
    {
        return articlesRepository.findAll();
    }

    public void deleteArticlesByID(Integer id)
    {
        articlesRepository.deleteById(id);

    }

    public Articles postArticles(Articles articles)
    {
        return articlesRepository.save(articles) ;
    }

    public Articles getArticlesByID (Integer id)
    {
        try 
        {
            return articlesRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }

    public void updateArticles(Integer id , Articles articles)
    {
        Articles articlesToUpdate = getArticlesByID(id) ;

        if(articlesToUpdate == null) return;

        if(articles.getNameArticles()!=null)

        articlesToUpdate.setNameArticles(articles.getNameArticles());        

        postArticles(articlesToUpdate) ;
    }

    public Articles getByName(String articlesName) throws ArticleFamilyNotFoundException
    {
        try 
        {
            return articlesRepository.findArticlesLikeName(articlesName).get();
        } 
        catch (Exception e) 
        {
            throw new ArticleFamilyNotFoundException("Could not find the articles " + articlesName );
        }
    }
}
