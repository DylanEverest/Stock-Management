package com.enterprise.stockmanagement.Movement.Entities.view;

import java.sql.Timestamp;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name ="movementview")
@Immutable
public class MovementView 
{

    @Id
    private Integer movementId;

    private Timestamp dateMovement ;

    private Integer methodType ;

    private Double quantity ;

    private Double unitPrice;

    private Double actualPriceStock ;

    private String family ;

    private String storeName ;


    public Timestamp getDateMovement() {
        return dateMovement;
    }

    public void setDateMovement(Timestamp dateMovement) {
        this.dateMovement = dateMovement;
    }

    public Integer getMethodType() {
        return methodType;
    }

    public void setMethodType(Integer methodType) {
        this.methodType = methodType;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getActualPriceStock() {
        return actualPriceStock;
    }

    public void setActualPriceStock(Double actualPriceStock) {
        this.actualPriceStock = actualPriceStock;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getMovementId() {
        return movementId;
    }

    public void setMovementId(Integer movementId) {
        this.movementId = movementId;
    }

}
