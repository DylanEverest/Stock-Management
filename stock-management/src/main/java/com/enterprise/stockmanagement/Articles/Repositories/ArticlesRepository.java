package com.enterprise.stockmanagement.Articles.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

public interface ArticlesRepository extends JpaRepository<Articles, Integer>{
    
    @Query("SELECT u FROM  articles u WHERE u.name_articles LIKE :family")
    Optional<Articles> findArticlesLikeName(@Param("family") String family);

}
