package com.enterprise.stockmanagement.Movement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.Movement.DTO.FormMovementDTO;
import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Service.in.MovementINService;
import com.enterprise.stockmanagement.Movement.Service.out.MovementOUTService;

@RestController

public class MovementController {
    
    @Autowired MovementINService movementINService;

    @Autowired MovementOUTService movementOUTService ;

    @Autowired Movement movementModel ;


    @PostMapping("/in")
    public FormMovementDTO inStock(@RequestBody FormMovementDTO formMovementDTO){

        try 
        {
            movementModel.setArticles(formMovementDTO.getArticle());
            movementModel.setDateMovement(formMovementDTO.getMovementDate());
            movementModel.setStore(formMovementDTO.getStore());
            movementModel.setMethodType(1);

            movementINService.in(movementModel) ;


        } 
        catch (Exception e) 
        {
            formMovementDTO.setErrors(e.getMessage());
        }

        return formMovementDTO;
    }

    @PostMapping("/out")
    public FormMovementDTO outStock(@RequestBody FormMovementDTO formMovementDTO){

        try 
        {
            movementModel.setArticles(formMovementDTO.getArticle());
            movementModel.setDateMovement(formMovementDTO.getMovementDate());
            movementModel.setStore(formMovementDTO.getStore());
            movementModel.setMethodType(1);
            movementModel.setQuantity((formMovementDTO.getQuantity()));

            movementOUTService.out(movementModel) ;
            

        } 
        catch (Exception e) 
        {
            formMovementDTO.setErrors(e.getMessage());
        }

        return formMovementDTO;
    }

}
