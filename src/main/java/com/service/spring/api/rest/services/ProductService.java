package com.service.spring.api.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.spring.api.rest.dto.ProductDto;
import com.service.spring.api.rest.entity.Category;
import com.service.spring.api.rest.mapper.ProductMapper;
import com.service.spring.api.rest.repository.CategoryRepository;
import com.service.spring.api.rest.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository produitRepository;
    private final CategoryRepository categorieRepository;
    private final ProductMapper produitMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProduitsParCategorie(Long categorieId) {
        // Récupérer tous les IDs des catégories
        List<Long> categorieIds = new ArrayList<>();
        collectCategorieIds(categorieId, categorieIds);

        // Requête produits
        return produitRepository
                .findByCategorieIdIn(categorieIds)
                .stream()
                .map(produitMapper::mapToProduct)
                .toList();
    }

    private void collectCategorieIds(Long categorieId, List<Long> ids) {
        ids.add(categorieId);

        List<Category> cList = categorieRepository.findByParentId(categorieId);

        for (Category c : cList) {
            collectCategorieIds(c.getId(), ids);
        }
    }
}
