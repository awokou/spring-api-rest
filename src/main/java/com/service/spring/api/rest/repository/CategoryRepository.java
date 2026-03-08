package com.service.spring.api.rest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.spring.api.rest.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByParentIsNull(); // catégories racines

    List<Category> findByParentId(Long parentId);

    Optional<Category> findByNom(String nom);

    Optional<Category> findByNomAndParent(String nom, Category parent);
}
