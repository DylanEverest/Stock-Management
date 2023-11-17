package com.enterprise.stockmanagement.UnitConversion.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.UnitConversion.entity.Conversion;
import com.enterprise.stockmanagement.UnitConversion.repository.ConversionRepository;

@Service
public class CRUDConversion {
    
    @Autowired
    ConversionRepository conversionRepository ;

    public List<Conversion> getConversionList() 
    {
        return conversionRepository.findAll();
    }

    public void deleteConversionByID(Integer id)
    {
        conversionRepository.deleteById(id);

    }

    public Conversion postConversion(Conversion conversion)
    {
        return conversionRepository.save(conversion) ;
    }

    public Conversion getConversionByID (Integer id)
    {
        try 
        {
            return conversionRepository.findById(id).get();
        } 
        catch (java.util.NoSuchElementException e) 
        {
            return null ;
        }
    }


}
