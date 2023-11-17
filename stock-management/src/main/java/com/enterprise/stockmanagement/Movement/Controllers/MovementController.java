package com.enterprise.stockmanagement.Movement.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.enterprise.stockmanagement.Articles.Services.CRUDArticles;
import com.enterprise.stockmanagement.Movement.DTO.FormMovementDTO;
import com.enterprise.stockmanagement.Movement.Entities.Movement;
import com.enterprise.stockmanagement.Movement.Service.in.MovementINService;
import com.enterprise.stockmanagement.Movement.Service.out.MovementOUTService;
import com.enterprise.stockmanagement.Store.Services.CRUDStore;
import com.enterprise.stockmanagement.UnitConversion.Service.ConversionService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Autoriser les requêtes depuis ce domaine
public class MovementController {
    
    @Autowired MovementINService movementINService;

    @Autowired MovementOUTService movementOUTService ;

    @Autowired CRUDArticles articlesService ;

    @Autowired CRUDStore storeService;

    @Autowired ConversionService conversionService ;


    @PostMapping("/in")
    public FormMovementDTO inStock(@RequestBody FormMovementDTO formMovementDTO){
        Movement movementModel = new Movement();
        try 
        {
            movementModel.setArticles( articlesService.getByName(formMovementDTO.getArticle()) );
            movementModel.setDateMovement(formMovementDTO.getMovementDate());
            movementModel.setStore(storeService.getByName(formMovementDTO.getStore()));
            movementModel.setMethodType(1);
            movementModel.setQuantity(formMovementDTO.getQuantity());
            movementModel.setUnitPrice(formMovementDTO.getUnitPrice());

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
        Movement movementModel = new Movement();

        try 
        {
            movementModel.setArticles( articlesService.getByName(formMovementDTO.getArticle()) );
            movementModel.setDateMovement(formMovementDTO.getMovementDate());
            movementModel.setStore(storeService.getByName(formMovementDTO.getStore()));
            movementModel.setMethodType(1);
            movementModel.setQuantity((formMovementDTO.getQuantity()));
            // appel a un service pour faire la conversion
            conversionService.conversion(movementModel ,formMovementDTO.getUnit());

            System.out.println(movementModel.getQuantity());           


            movementOUTService.out(movementModel) ;
            

        } 
        catch (Exception e) 
        {
            formMovementDTO.setErrors(e.getMessage());
        }

        return formMovementDTO;
    }

}
