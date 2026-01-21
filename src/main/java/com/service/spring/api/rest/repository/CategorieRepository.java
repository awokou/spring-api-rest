package com.service.spring.api.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.spring.api.rest.entity.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    List<Categorie> findByParentIsNull(); // catégories racines

    List<Categorie> findByParentId(Long parentId);

    Optional<Categorie> findByNom(String nom);

    Optional<Categorie> findByNomAndParent(String nom, Categorie parent);
}
