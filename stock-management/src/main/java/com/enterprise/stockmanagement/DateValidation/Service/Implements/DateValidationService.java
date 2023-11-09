package com.enterprise.stockmanagement.DateValidation.Service.Implements;

import com.enterprise.stockmanagement.DateValidation.Service.Implements.Exception.DateUnvalidExcetion;

public interface DateValidationService <T>
{

    public T isValid(String date) throws DateUnvalidExcetion;

    public boolean isSuccessive(T date1 , T date2) ;

    
}
