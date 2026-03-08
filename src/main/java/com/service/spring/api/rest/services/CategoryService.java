package com.service.spring.api.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.mapper.CategoryMapper;
import com.service.spring.api.rest.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categorieRepository;
    private final CategoryMapper categorieMapper;

    @Override
    public List<CategorieDto> getCategoriesRacines() {
        return categorieRepository.findByParentIsNull()
                .stream()
                .map(categorieMapper::mapToCategorieDto)
                .toList();
    }
}
