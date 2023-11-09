package com.enterprise.stockmanagement.DateValidation.Service.Timestamp;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.enterprise.stockmanagement.DateValidation.Service.Implements.DateValidationService;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.NotSuccessiveDate;
import com.enterprise.stockmanagement.DateValidation.Service.Implements.Exception.DateUnvalidExcetion;

public class TimestampValidation implements DateValidationService<Timestamp>{

    @Override
    public  Timestamp isValid(String date) throws TimestampUnvalidExcetion
    {
        try 
        {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

            java.util.Date newDate = format.parse(date);

            return new Timestamp(newDate.getTime());
            
        } catch (Exception e) 
        {
            throw new TimestampUnvalidExcetion("Invalid date format with "+date);
        }
    }

    @Override
    public void checkSuccessive(Timestamp date1, Timestamp date2) throws NotSuccessiveDate {
        if (! date2.after(date1)) 
        {
            throw new NotSuccessiveDate(""+date1+" and "+date2+" are not successive");
        }
    }

    @Override
    public void checkSuccessive(String date1, String date2) throws DateUnvalidExcetion, NotSuccessiveDate {
        Timestamp date01 = isValid(date1);
        Timestamp date02 = isValid(date2);

        checkSuccessive(date01, date02);
    }


    
}
