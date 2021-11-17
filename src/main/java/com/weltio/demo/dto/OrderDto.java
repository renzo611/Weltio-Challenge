package com.weltio.demo.dto;

import com.weltio.demo.model.Order;
import com.weltio.demo.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class OrderDto {

    private Set<Product> products = new HashSet<>();

    public static Order mapToEntity(OrderDto order){
        Order newOrder = new Order();
        newOrder.setProducts(order.getProducts());
        return newOrder;
    }

    public static OrderDto mapToDto(Order order){
        OrderDto newOrder = new OrderDto();
        newOrder.setProducts(order.getProducts());
        return newOrder;
    }


}
