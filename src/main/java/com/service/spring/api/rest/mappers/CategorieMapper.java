package com.service.spring.api.rest.mappers;

import java.util.stream.Collectors;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.entity.Categorie;

public class CategorieMapper {

    public static CategorieDto toDTO(Categorie categorie) {
        if (categorie == null)
            return null;

        CategorieDto dto = new CategorieDto(
                categorie.getId(),
                categorie.getNom(),
                categorie.getDescription(),
                null); // Initialisation de sousCategories à null

        // Mapping récursif contrôlé
        if (categorie.getSousCategories() != null) {
            dto.setSousCategories(
                    categorie.getSousCategories()
                            .stream()
                            .map(CategorieMapper::toDTO)
                            .collect(Collectors.toList()));
        }

        return dto;
    }
}
