package com.service.spring.api.rest.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.service.spring.api.rest.dto.CategorieDto;
import com.service.spring.api.rest.mappers.CategorieMapper;
import com.service.spring.api.rest.repository.CategorieRepository;

@Service
public class CategorieService implements ICategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    public List<CategorieDto> getCategoriesRacines() {
        return categorieRepository.findByParentIsNull()
                .stream()
                .map(CategorieMapper::toDTO)
                .toList();
    }
}
