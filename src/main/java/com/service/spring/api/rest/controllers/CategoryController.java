package com.service.spring.api.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categorieService;

    public CategoryController(CategoryService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/tree")
    public List<CategorieDto> getTree() {
        return categorieService.getCategoriesRacines();
    }
}
