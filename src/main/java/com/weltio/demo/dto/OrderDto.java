package com.weltio.demo.dto;

import com.weltio.demo.model.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OrderDto {
    private Long id;
    @NotEmpty(message = "This list is empty")
    private Set<Product> products = new HashSet<>();
}
