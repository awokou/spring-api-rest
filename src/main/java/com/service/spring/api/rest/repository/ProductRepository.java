package com.service.spring.api.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.spring.api.rest.entity.Category;
import com.service.spring.api.rest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategorieIdIn(List<Long> categorieIds);

    boolean existsByNomAndCategorie(String nom, Category categorie);
}
