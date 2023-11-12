package com.enterprise.stockmanagement.Movement.Service.INFO;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Repositories.MovementRepository;

@Service
public class MovementINFOService {

    @Autowired
    MovementRepository movementRepository ;


    public List<Movement> getAllByMethod(Integer type)
    {
        return movementRepository.findAllByMethodType(type) ;
    }

    public List<Movement> getAllButReportingWithDateMovementInferiorTo(Timestamp date)
    {
        return movementRepository.findAllButReportingWithDateMovementInferiorTo(date) ;
    }

    public Timestamp getLastReportDate(Timestamp date)
    {
        try 
        {
            return movementRepository.findLastReportDate(date).get() ;
        } 
        catch (Exception e) 
        {
            return null ;
        }
    }

    public List<Movement> getAllWithDateMovementBetween(Timestamp date1 ,Timestamp date2)
    {
        return movementRepository.findAllWithDateMovementBetween(date1,date2);
    }

    public List<Movement> getAllWithDateMovementBetweenWithClosedInterval(Timestamp date1 ,Timestamp date2)
    {
        return movementRepository.findAllWithDateMovementBetweenWithClosedInterval(date1,date2);
    }

    
}
