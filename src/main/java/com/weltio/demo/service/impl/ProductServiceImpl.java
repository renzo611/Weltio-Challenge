package com.weltio.demo.service.impl;

import com.weltio.demo.dto.ProductFiltersDto;
import com.weltio.demo.mapper.ProductMapper;
import com.weltio.demo.model.Product;
import com.weltio.demo.repository.ProductRepository;
import com.weltio.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Set<ProductFiltersDto> findAllBetweenIn2Date(Date init, Date end) {
        List<Product> products = new ArrayList<>();
        products = productRepository.findAllByCreationTimeBetween(init,end);
        return ProductMapper.mapListToDto(products);
    }
}
