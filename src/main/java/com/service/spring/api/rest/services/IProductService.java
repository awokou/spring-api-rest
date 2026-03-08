package com.service.spring.api.rest.services;

import java.util.List;

import com.service.spring.api.rest.dto.ProductDto;

public interface IProductService {

    List<ProductDto> getProduitsParCategorie(Long categorieId);
}
