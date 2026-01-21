package com.service.spring.api.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.api.rest.dto.ProduitDto;
import com.service.spring.api.rest.services.ProduitService;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @GetMapping("/categorie/{id}")
    public List<ProduitDto> getByCategorie(@PathVariable Long id) {
        return produitService.getProduitsParCategorie(id);
    }
}
