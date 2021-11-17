package com.weltio.demo.mapper;

import com.weltio.demo.dto.ProductFiltersDto;
import com.weltio.demo.model.Product;

import java.util.*;

public class ProductMapper {
    public static Set<ProductFiltersDto> mapListToDto(List<Product> products){
        Set<ProductFiltersDto> newList = new HashSet<>();
        ProductFiltersDto productDto;
        for (Product p : products) {
            productDto = mapToDtoFilter(p);
            if(newList.contains(productDto)) {
                for (ProductFiltersDto a: newList) {
                    if(a.getName().toUpperCase().equals(p.getName().toUpperCase())){
                        a.setCuantity(a.getCuantity() + p.getCuantity());
                        a.setTotalprice(a.getTotalprice() + (p.getCuantity() * p.getPrice()));
                    }
                }
            }else{
                newList.add(productDto);
            }
        }

        return newList;
    }

    private static ProductFiltersDto mapToDtoFilter(Product product){
        ProductFiltersDto newProduct = new ProductFiltersDto();
        newProduct.setTotalprice(product.getPrice() * product.getCuantity());
        newProduct.setName(product.getName());
        newProduct.setCuantity(product.getCuantity());
        return newProduct;
    }
}
