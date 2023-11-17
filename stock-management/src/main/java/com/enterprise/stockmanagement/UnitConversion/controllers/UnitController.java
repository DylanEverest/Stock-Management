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
    private UnitDTO unitDTO ;


    @GetMapping(path = "/unit")
    public UnitDTO getUnits()
    {
        List<Unit> unit = crudUnit.getUnitList() ;
        unitDTO.setUnitAsList(unit);
        return unitDTO ;
    }

    @GetMapping(path = "/unit/{id}")
    public UnitDTO getUnitsById(@PathVariable("id") final Integer id)
    {
        Unit unit = crudUnit.getUnitByID(Integer.valueOf(id)) ;
        unitDTO.setUnit(unit) ;

        return unitDTO ;
    }

    @PostMapping(path = "/unit")
    public UnitDTO saveUnit(@RequestBody UnitDTO unitDTO)
    {
        try {
            crudUnit.postUnit(unitDTO.getUnit());
            
        } catch (Exception e) {
            unitDTO.setErrors(e.getMessage());
        }

        return unitDTO;

    }    
    
}