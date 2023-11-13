package com.enterprise.stockmanagement.Movement.Service.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Models.Remnant;
import com.enterprise.stockmanagement.Movement.Repositories.MovementRepository;
import com.enterprise.stockmanagement.Movement.Service.out.Exception.OutQuantityNotSupportedException;

@Service
public class MovementOUTService {
    
    @Autowired 
    MovementRepository movementRepository ;

    public List <Movement> getMovements() {
    
        return movementRepository.findAllByMethodType(2);
    }

    public Movement out(Movement movement) throws OutQuantityNotSupportedException
    {
        movement.setMethodType(2);

        // some logics
        outs(getPossibleOUT(movement));

        return movement ;
    }

    public void outs(Movement [] movement)
    {
        List<Movement> list = new ArrayList<Movement>();
        for (int i = 0; i < movement.length; i++) {

            movement[i].setMethodType(2);
            list.add(movement[i]);
        }

        movementRepository.saveAll(list) ;

    }



    public Movement [] getPossibleOUT(Movement movementExcepted) throws OutQuantityNotSupportedException 
    {
        List<Movement> possibleOut = new ArrayList<Movement>() ;
        Double quantityTarget = movementExcepted.getQuantity();
        List <Movement> entryList , outList ;
        entryList =movementRepository.findAllByMethodType(1) ;
        outList = movementRepository.findAllByMethodType(2) ;

        // eto tokony mbola misy hoe fifo sa lifo

        Remnant[] remnants = new Remnant().getRemnants( entryList.toArray(new Movement[entryList.size()]),
                                                        outList.toArray(new Movement[outList.size()]) 
                                                      ) ;
        for (int i = 0; i < remnants.length; i++) {
            Movement movement = new Movement();
            movement.setArticles(movementExcepted.getArticles());
            movement.setDateMovement(movementExcepted.getDateMovement());
            movement.setStore(movementExcepted.getStore());

            if (remnants[i].getQuantity()>=quantityTarget) 
            {
                movement.setUnitPrice(remnants[i].getUnitPrice());
                movement.setQuantity(quantityTarget * -1);
                possibleOut.add(movement);                

                return possibleOut.toArray(new Movement[possibleOut.size()]);
            }
            else
            {
                quantityTarget = quantityTarget -remnants[i].getQuantity() ;
            }
        }
        throw new OutQuantityNotSupportedException("The stock quantity is missing "+quantityTarget);

    }
}
