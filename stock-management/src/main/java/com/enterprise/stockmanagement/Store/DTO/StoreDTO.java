package com.enterprise.stockmanagement.Store.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Store.Entities.Store;

@Component
public class StoreDTO 
{
    @Autowired
    Store [] listStore ;    

    Store store ;

    String errors ;

    public void setStoreAsList(List<Store> list)
    {
        listStore = list.toArray(new Store[list.size()]);
    }

    public Store[] getListStore() {
        return listStore;
    }

    public void setListStore(Store[] listStore) {
        this.listStore = listStore;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
