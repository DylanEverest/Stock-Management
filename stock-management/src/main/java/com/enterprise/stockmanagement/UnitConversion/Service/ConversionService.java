package com.enterprise.stockmanagement.UnitConversion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.UnitConversion.entity.Unit;
import com.enterprise.stockmanagement.UnitConversion.repository.ConversionRepository;
import com.enterprise.stockmanagement.UnitConversion.repository.UnitRepository;

@Service
public class ConversionService {

    @Autowired
    ConversionRepository conversionRepository;

    @Autowired UnitRepository unitRepository ;


    public void conversion (Movement model ,String unitDefault) throws Exception
    {
        Double factor = getFactor(model.getArticles().getUnit(), unitDefault) ;

        if (factor == null) {
            throw new Exception("no formula for the unit") ;
        }
        model.setQuantity( model.getQuantity() /factor);
    }
    
    public Double getFactor(Unit unitTarget  , String unitDefault) throws Exception
    {
        // alaina ilay unite anle unitDefault
       Unit defaultUnit ;
        try 
        {
          defaultUnit = unitRepository.findByName(unitDefault).get() ;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage()) ;

            throw new Exception("Not valid unit for "+unitDefault) ;
        }
        
        // alaina ilay facteur de conversion
        System.out.println(unitTarget.getUnitId());
        System.out.println(defaultUnit.getUnitId());
        System.out.println("--");
        Double factor = conversionRepository.findFactor(defaultUnit.getUnitId() ,unitTarget.getUnitId()) ;



        return factor ;
    }
    
}
