package com.enterprise.stockmanagement.DateValidation.Service;

import java.sql.Timestamp;

import com.enterprise.stockmanagement.DateValidation.Service.Implements.DateValidationService;

public class TimestampValidation implements DateValidationService<Timestamp>{

    @Override
    public boolean isValid() {
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    @Override
    public boolean isSuccessive(Timestamp date1, Timestamp date2) {

        throw new UnsupportedOperationException("Unimplemented method 'isSuccessive'");
    }
    
}
