package com.weltio.demo.mapper;

import com.weltio.demo.dto.OrderDto;
import com.weltio.demo.model.Order;

public class OrderMapper {
    public static Order mapToEntity(OrderDto order){
        Order newOrder = new Order();
        newOrder.setProducts(order.getProducts());
        return newOrder;
    }

    public static OrderDto mapToDto(Order order){
        OrderDto newOrder = new OrderDto();
        newOrder.setId(order.getId());
        newOrder.setProducts(order.getProducts());
        return newOrder;
    }
}
