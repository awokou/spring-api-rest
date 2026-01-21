package com.service.spring.api.rest.mappers;

import com.service.spring.api.rest.dto.ProduitDto;
import com.service.spring.api.rest.entity.Produit;

public class ProduitMapper {

    public static ProduitDto toDTO(Produit produit) {
        return new ProduitDto(
                produit.getId(),
                produit.getNom(),
                produit.getPrix(),
                produit.getStock(),
                produit.getCategorie().getId(),
                produit.getCategorie().getNom());
    }
}
