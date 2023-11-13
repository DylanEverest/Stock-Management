package com.enterprise.stockmanagement.Movement.Service.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Repositories.MovementRepository;

@Service
public class MovementOUTService {
    
    @Autowired 
    MovementRepository movementRepository ;

    public List <Movement> getMovements() {
    
        return movementRepository.findAllByMethodType(2);
    }

    public Movement out(Movement movement)
    {
        movement.setMethodType(2);

        // some logics

        return movementRepository.save(movement) ;
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
}
