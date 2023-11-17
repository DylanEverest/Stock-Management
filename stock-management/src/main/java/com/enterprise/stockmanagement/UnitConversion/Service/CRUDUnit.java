package com.enterprise.stockmanagement.UnitConversion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.UnitConversion.entity.Unit;
import com.enterprise.stockmanagement.UnitConversion.repository.UnitRepository;


@Service
public class CRUDUnit {
    

    @Autowired
    UnitRepository articlesRepository ;

    public List<Unit> getUnitList() 
    {
        return articlesRepository.findAll();
    }

    public void deleteUnitByID(Integer id)
    {
        articlesRepository.deleteById(id);

    }

    public Unit postUnit(Unit articles)
    {
        return articlesRepository.save(articles) ;
    }

    public Unit getUnitByID (Integer id)
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

    public void updateUnit(Integer id , Unit articles)
    {
        Unit articlesToUpdate = getUnitByID(id) ;

        if(articlesToUpdate == null) return;

        if(articles.getName()!=null)

        articlesToUpdate.setName(articles.getName());        

        postUnit(articlesToUpdate) ;
    }

    public Unit getByName(String articlesName) throws Exception
    {
        try 
        {
            return articlesRepository.findByName(articlesName).get();
        } 
        catch (Exception e) 
        {
            throw new Exception("Could not find the articles " + articlesName );
        }
    }
}
