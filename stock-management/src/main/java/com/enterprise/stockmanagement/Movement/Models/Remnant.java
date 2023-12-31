package com.enterprise.stockmanagement.Movement.Models;

import java.util.ArrayList;

import com.enterprise.stockmanagement.Movement.Entities.Movement;

public class Remnant 
{
    String familly ;
    String store ;
    Double quantity ;
    Double unitPrice ;


    public Remnant [] getRemnants(Movement [] entry ,Movement [] out) {
        ArrayList<Remnant> list = new ArrayList<Remnant>();
        int entryIndex =0 ;

        // init list
        for (int i = 0; i < entry.length; i++) {
            Remnant tmp = new Remnant();
            tmp.setFamilly(entry[i].getArticles().getFamily());
            tmp.setQuantity(entry[i].getQuantity());
            tmp.setStore(entry[i].getStore().getStoreName());
            tmp.setUnitPrice(entry[i].getUnitPrice());

            list.add(tmp);
        }

        try {
            for (int i = 0; i < out.length; i++) {
            
                if (out[i].getQuantity().doubleValue() *-1 <= list.get(entryIndex).getQuantity().doubleValue()) 
                {
                    list.get(entryIndex).setQuantity(list.get(entryIndex).getQuantity()+out[i].getQuantity());
                }
                else 
                {
                    // index manipulation
                    entryIndex++;
                    i-- ;
                }
            }
                
        } catch (Exception e) {
            throw e ;
        }


        return list.toArray(new Remnant[list.size()]);
    }

    public String getFamilly() {
        return familly;
    }
    public void setFamilly(String familly) {
        this.familly = familly;
    }
    public String getStore() {
        return store;
    }
    public void setStore(String store) {
        this.store = store;
    }
    public Double getQuantity() {
        return quantity;
    }
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    public Double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }    
}
