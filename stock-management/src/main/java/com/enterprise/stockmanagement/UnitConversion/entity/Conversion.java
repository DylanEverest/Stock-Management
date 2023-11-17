package com.enterprise.stockmanagement.UnitConversion.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Conversion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer conversionId  ;

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private Unit unitSource ; // example 1Kg

    @ManyToOne(optional = false ,fetch = FetchType.EAGER)
    private Unit unitDestination ; // g

    private double factor ; // 1000



    public Integer getConversionId() {
        return conversionId;
    }

    public void setConversionId(Integer conversionId) {
        this.conversionId = conversionId;
    }

    public Unit getUnitSource() {
        return unitSource;
    }

    public void setUnitSource(Unit unitSource) {
        this.unitSource = unitSource;
    }

    public Unit getUnitDestination() {
        return unitDestination;
    }

    public void setUnitDestination(Unit unitDestination) {
        this.unitDestination = unitDestination;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    // 1kg -> 1000 g
}
