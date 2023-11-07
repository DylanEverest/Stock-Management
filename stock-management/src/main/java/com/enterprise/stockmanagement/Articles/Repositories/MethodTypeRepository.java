package com.enterprise.stockmanagement.Articles.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.stockmanagement.Articles.Entities.MethodType;

public interface MethodTypeRepository extends JpaRepository<MethodType,Integer>{
    
}
