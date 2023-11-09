package com.enterprise.stockmanagement.Store.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Store.Entities.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer>
{
    Optional<Store> findByStoreName(@Param("storeName") String storeName);    

    @Query(value = "SELECT 1 <= count(a.name_articles) FROM (SELECT * FROM articles u WHERE u.name_articles LIKE %:storeName%) as a", nativeQuery = true)
    boolean existsStoreName(@Param("storeName") String storeName);
}
