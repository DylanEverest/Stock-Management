package com.enterprise.stockmanagement.DateValidation.Service.Timestamp;

import java.sql.Timestamp;

import com.enterprise.stockmanagement.DateValidation.Service.Implements.DateValidationService;

public class TimestampValidation implements DateValidationService<Timestamp>{

    @Override
    public Timestamp isValid(String date) throws TimestampUnvalidExcetion
    {
        try 
        {
            return Timestamp.valueOf(date) ;
            
        } catch (Exception e) 
        {
            throw new TimestampUnvalidExcetion("Invalid date format with "+date);
        }
    }

    @Override
    public boolean isSuccessive(Timestamp date1, Timestamp date2) {

        throw new UnsupportedOperationException("Unimplemented method 'isSuccessive'");
    }
    
}
