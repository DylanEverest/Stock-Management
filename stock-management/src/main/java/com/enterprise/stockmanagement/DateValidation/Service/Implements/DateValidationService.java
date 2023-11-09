package com.enterprise.stockmanagement.DateValidation.Service.Implements;

public interface DateValidationService <T>
{

    public boolean isValid(T date);

    public boolean isSuccessive(T date1 , T date2) ;

    
}
