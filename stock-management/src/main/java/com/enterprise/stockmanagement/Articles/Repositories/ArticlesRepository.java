package com.enterprise.stockmanagement.Articles.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.enterprise.stockmanagement.Articles.Entities.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Integer>{
    
    Optional<Articles> findByNameArticles(@Param("nameArticles") String nameArticles);

    @Query(value = "SELECT 1 <= count(a.family) FROM (SELECT * FROM articles u WHERE u.family LIKE %:family%) as a", nativeQuery = true)
    boolean existsFamily(@Param("family") String family);


}
