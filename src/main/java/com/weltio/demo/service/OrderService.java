package com.weltio.demo.service;

import com.weltio.demo.dto.OrderDto;
import com.weltio.demo.exception.NotFoundException;

public interface OrderService {
    public OrderDto save(OrderDto order);
    public String delete(Long id) throws NotFoundException;
    public OrderDto update(Long id, OrderDto order) throws NotFoundException;
}
