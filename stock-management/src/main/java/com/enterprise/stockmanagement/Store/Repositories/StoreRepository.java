package com.enterprise.stockmanagement.Store.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.stockmanagement.Store.Entities.Store;

public interface StoreRepository extends JpaRepository<Store,Integer>
{
    
}
