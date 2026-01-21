package com.service.spring.api.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.services.CategorieService;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/tree")
    public List<CategorieDto> getTree() {
        return categorieService.getCategoriesRacines();
    }
}
