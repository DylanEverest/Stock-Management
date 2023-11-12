package com.enterprise.stockmanagement.Movement.Service.operation;

import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;

@Service
public class MovementOperationService 
{

    public Double sumAllQuantity( Movement[] movement) 
    {
        Double sum = 0.; 

        for (int i = 0; i < movement.length; i++) {
            sum += movement[i].getQuantity();
        }

        return sum;
    }

    public Double sumAllQuantityTimesPrice(Movement [] movements) 
    {

        Double sum = 0.; 

        for (int i = 0; i < movements.length; i++) {
            sum += movements[i].getQuantity() *movements[i].getUnitPrice();
        }

        return sum;
    }



    
}
