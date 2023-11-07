package com.enterprise.stockmanagement.Articles.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

public interface ArticlesRepository extends JpaRepository<Articles, Integer>{
    
}
