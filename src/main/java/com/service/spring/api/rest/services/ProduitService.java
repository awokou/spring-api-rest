package com.service.spring.api.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.spring.api.rest.dto.ProduitDto;
import com.service.spring.api.rest.entity.Categorie;
import com.service.spring.api.rest.mappers.ProduitMapper;
import com.service.spring.api.rest.repository.CategorieRepository;
import com.service.spring.api.rest.repository.ProduitRepository;

@Service
public class ProduitService implements IProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitService(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProduitDto> getProduitsParCategorie(Long categorieId) {
        // Récupérer tous les IDs des catégories
        List<Long> categorieIds = new ArrayList<>();
        collectCategorieIds(categorieId, categorieIds);

        // Requête produits
        return produitRepository
                .findByCategorieIdIn(categorieIds)
                .stream()
                .map(ProduitMapper::toDTO)
                .toList();
    }

    private void collectCategorieIds(Long categorieId, List<Long> ids) {
        ids.add(categorieId);

        List<Categorie> cList = categorieRepository.findByParentId(categorieId);

        for (Categorie c : cList) {
            collectCategorieIds(c.getId(), ids);
        }
    }
}
