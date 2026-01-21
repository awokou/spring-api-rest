package com.service.spring.api.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategorieDto {

    private Long id;
    private String nom;
    private String description;

    // Sous-catégories récursives (mais contrôlées)
    private List<CategorieDto> sousCategories;
}
