package com.enterprise.stockmanagement.Movement.Service.in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Repositories.MovementRepository;

@Service
public class MovementINService {

    @Autowired 
    MovementRepository movementRepository ;

    public List <Movement> getMovements() {
    
        return movementRepository.findAllByMethodType(1);
    }

    public Movement in(Movement movement)
    {
        movement.setMethodType(1);

        return movementRepository.save(movement) ;
    }
    
}
