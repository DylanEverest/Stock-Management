package com.enterprise.stockmanagement.Movement.Service.INFO;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.view.MovementView;
import com.enterprise.stockmanagement.Movement.Repositories.view.MovementViewRepository;

@Service
public class MovementINFOService {

    @Autowired
    MovementViewRepository movementViewRepository ;


    public List<MovementView> getAllByMethod(Integer type)
    {
        return movementViewRepository.findAllByMethodType(type) ;
    }

    public List<MovementView> getAllButReportingWithDateMovementInferiorOrEqualTo(Timestamp date)
    {
        return movementViewRepository.findAllButReportingWithDateMovementInferiorOrEqualTo(date) ;
    }

    public Timestamp getLastReportDate(Timestamp date)
    {
        try 
        {
            return movementViewRepository.findLastReportDate(date).get() ;
        } 
        catch (Exception e) 
        {
            return null ;
        }
    }

    public List<MovementView> getAllWithDateMovementBetween(Timestamp date1 ,Timestamp date2)
    {
        return movementViewRepository.findAllWithDateMovementBetween(date1,date2);
    }

    public List<MovementView> getAllWithDateMovementBetweenWithClosedInterval(Timestamp date1 ,Timestamp date2)
    {
        return movementViewRepository.findAllWithDateMovementBetweenWithClosedInterval(date1,date2);
    }

    
}
