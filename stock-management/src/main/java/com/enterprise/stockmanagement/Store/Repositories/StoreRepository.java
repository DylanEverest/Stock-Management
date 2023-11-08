package com.enterprise.stockmanagement.Store.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.enterprise.stockmanagement.Store.Entities.Store;

public interface StoreRepository extends JpaRepository<Store,Integer>
{
    Optional<Store> findByStoreName(@Param("storeName") String storeName);    
}
