package com.enterprise.stockmanagement.Movement.Repositories.view;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Movement.Entities.view.MovementView;

@Repository
public interface MovementViewRepository extends JpaRepository< MovementView,Integer>{
    
}
