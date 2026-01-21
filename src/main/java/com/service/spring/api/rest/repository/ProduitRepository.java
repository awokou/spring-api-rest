package com.service.spring.api.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.spring.api.rest.entity.Categorie;
import com.service.spring.api.rest.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
    List<Produit> findByCategorieIdIn(List<Long> categorieIds);

    boolean existsByNomAndCategorie(String nom, Categorie categorie);
}
