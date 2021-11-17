package com.weltio.demo.service;

import com.weltio.demo.dto.ProductFiltersDto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ProductService {
    Set<ProductFiltersDto> findAllBetweenIn2Date(Date init, Date end);
}
