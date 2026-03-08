package com.service.spring.api.rest.mapper;

import org.springframework.stereotype.Component;

import com.service.spring.api.rest.dto.ProductDto;
import com.service.spring.api.rest.entity.Product;

@Component
public class ProductMapper {

    public ProductDto mapToProduct(Product produit) {
        return new ProductDto(
                produit.getId(),
                produit.getNom(),
                produit.getPrix(),
                produit.getStock(),
                produit.getCategorie().getId(),
                produit.getCategorie().getNom());
    }
}
