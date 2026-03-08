package com.service.spring.api.rest.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.entity.Category;

@Component
public class CategoryMapper {

    public CategorieDto mapToCategorieDto(Category categorie) {
        if (categorie == null)
            return null;

        CategorieDto categorieDto = new CategorieDto(
                categorie.getId(),
                categorie.getNom(),
                categorie.getDescription(),
                null); // Initialisation de sousCategories à null

        // Mapping récursif contrôlé
        if (categorie.getSousCategories() != null) {
            categorieDto.setSousCategories(
                    categorie.getSousCategories()
                            .stream()
                            .map(this::mapToCategorieDto)
                            .collect(Collectors.toList()));
        }

        return categorieDto;
    }
}
