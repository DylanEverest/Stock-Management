package com.enterprise.stockmanagement.UnitConversion.DTO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.enterprise.stockmanagement.UnitConversion.entity.Unit;

@Component
public class UnitDTO 
{
    @Autowired
    Unit [] listUnit ;    

    String errors ;

    @Autowired
    Unit articles ;

    public void setUnitAsList(List<Unit> list)
    {
        listUnit = list.toArray(new Unit[list.size()]);
    }

    public Unit[] getListUnit() {
        return listUnit;
    }

    public void setListUnit(Unit[] listUnit) {
        this.listUnit = listUnit;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Unit getUnit() {
        return articles;
    }

    public void setUnit(Unit articles) {
        this.articles = articles;
    }


}
