package com.enterprise.stockmanagement.DateValidation.Service.Implements;

import com.enterprise.stockmanagement.DateValidation.Service.Implements.Exception.DateUnvalidExcetion;

public interface DateValidationService <T>
{

    public T isValid(String date) throws DateUnvalidExcetion;

    public void checkSuccessive(T date1 , T date2) throws NotSuccessiveDate;

    public void checkSuccessive(String date1 , String date2) throws DateUnvalidExcetion , NotSuccessiveDate ;
    
}
