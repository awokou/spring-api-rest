package com.service.spring.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {

    private Long id;
    private String nom;
    private double prix;
    private int stock;

    // On évite la catégorie complète
    private Long categorieId;
    private String categorieNom;
}
