package com.weltio.demo.dto;

import com.weltio.demo.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class ProductFiltersDto {
    private String name;
    private Long cuantity;
    private float Totalprice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductFiltersDto product = (ProductFiltersDto) o;
        return this.name.toUpperCase().equals(((ProductFiltersDto) o).getName().toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
