package com.service.spring.api.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.api.rest.dto.ProductDto;
import com.service.spring.api.rest.services.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService produitService;

    public ProductController(ProductService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/categorie/{id}")
    public List<ProductDto> getByCategorie(@PathVariable Long id) {
        return produitService.getProduitsParCategorie(id);
    }
}
