package com.enterprise.stockmanagement.Store.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enterprise.stockmanagement.Store.Entities.Store;

@Component
public class StoreDTO 
{
    @Autowired
    Store [] stores ;    

    String errors ;

    public Store[] getStore() {
        return stores;
    }

    public void setStore(Store stores) {
        this.stores[0] = stores;
    }
    public void setStore(Store[] stores) {
        this.stores = stores;
    }
    public void setStore(List<Store> stores) {
        this.stores = stores.toArray(new Store[stores.size()]);
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
