package com.enterprise.stockmanagement.UnitConversion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.UnitConversion.DTO.UnitDTO;
import com.enterprise.stockmanagement.UnitConversion.Service.CRUDUnit;
import com.enterprise.stockmanagement.UnitConversion.entity.Unit;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Autoriser les requêtes depuis ce domaine
public class UnitController 
{

    @Autowired
    private CRUDUnit crudUnit ;

    @Autowired
    private UnitDTO unitsDTO ;


    @GetMapping(path = "/units")
    public UnitDTO getUnits()
    {
        List<Unit> units = crudUnit.getUnitList() ;
        unitsDTO.setUnitAsList(units);
        return unitsDTO ;
    }

    @GetMapping(path = "/units/{id}")
    public UnitDTO getUnitsById(@PathVariable("id") final Integer id)
    {
        Unit units = crudUnit.getUnitByID(Integer.valueOf(id)) ;
        unitsDTO.setUnit(units) ;

        return unitsDTO ;
    }

    @PostMapping(path = "/units")
    public UnitDTO saveUnit(@RequestBody UnitDTO unitsDTO)
    {
        try {
            crudUnit.postUnit(unitsDTO.getUnit());
            
        } catch (Exception e) {
            unitsDTO.setErrors(e.getMessage());
        }

        return unitsDTO;

    }    
    
}