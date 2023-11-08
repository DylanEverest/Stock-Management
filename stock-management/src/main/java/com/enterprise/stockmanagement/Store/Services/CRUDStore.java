package com.enterprise.stockmanagement.Store.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.enterprise.stockmanagement.Store.Entities.Store;
import com.enterprise.stockmanagement.Store.Repositories.StoreRepository;

public class CRUDStore {
    
    @Autowired
    StoreRepository storeRepository ;

    public List<Store> getStoreList() 
    {
        return storeRepository.findAll();
    }

    public void deleteStoreByID(Integer id)
    {
        storeRepository.deleteById(id);

    }

    public Store postStore(Store store)
    {
        return storeRepository.save(store) ;
    }

    public Store getStoreByID (Integer id)
    {
        try 
        {
            return storeRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }

    public void updateStore(Integer id , Store store)
    {
        Store storeToUpdate = getStoreByID(id) ;

        if(storeToUpdate == null) return;

        if(store.getStoreName()!=null)

        storeToUpdate.setStoreName(store.getStoreName());        

        postStore(storeToUpdate) ;
    }
}
