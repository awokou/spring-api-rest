package com.service.spring.api.rest.services;

import java.util.List;

import com.service.spring.api.rest.dto.ProduitDto;

public interface IProduitService {

    List<ProduitDto> getProduitsParCategorie(Long categorieId);
}
