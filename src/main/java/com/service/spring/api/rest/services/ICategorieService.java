package com.service.spring.api.rest.services;

import java.util.List;

import com.service.spring.api.rest.dto.CategorieDto;

public interface ICategorieService {

    List<CategorieDto> getCategoriesRacines();
}
