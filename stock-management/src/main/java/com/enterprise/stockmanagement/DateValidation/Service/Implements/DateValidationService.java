package com.enterprise.stockmanagement.DateValidation.Service.Implements;

public interface DateValidationService <T>
{

    public T isValid(String date);

    public boolean isSuccessive(T date1 , T date2) ;

    
}
