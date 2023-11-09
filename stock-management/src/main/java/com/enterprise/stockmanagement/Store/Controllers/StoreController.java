package com.enterprise.stockmanagement.Store.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.Store.DTO.StoreDTO;
import com.enterprise.stockmanagement.Store.Entities.Store;
import com.enterprise.stockmanagement.Store.Services.CRUDStore;

@RestController
public class StoreController 
{

    @Autowired
    private CRUDStore crudStore ;

    @Autowired
    private StoreDTO storesDTO ;


    @GetMapping(path = "/stores")
    public StoreDTO getStores()
    {
        List<Store> stores = crudStore.getStoreList() ;
        storesDTO.setStoreAsList(stores);
        return storesDTO ;
    }

    @GetMapping(path = "/stores/{id}")
    public StoreDTO getStoresById(@PathVariable("id") final Integer id)
    {
        Store stores = crudStore.getStoreByID(Integer.valueOf(id)) ;
        storesDTO.setStore(stores) ;

        return storesDTO ;
    }

    @PostMapping(path = "/stores")
    public StoreDTO saveStore(@RequestBody StoreDTO storesDTO)
    {
        crudStore.postStore(storesDTO.getStore());

        return storesDTO;

    }    

    @PutMapping(path ="/stores/{id}")
    public StoreDTO updateStore(@PathVariable("id") final Integer id , @RequestBody StoreDTO storesDTO)
    {
        crudStore.updateStore(id, storesDTO.getStore());

        return storesDTO;
    }

    @DeleteMapping(path = "/stores/{id}")
    public void deleteStore(@PathVariable("id") final Integer id)
    {
        crudStore.deleteStoreByID(id);
    }    
}
