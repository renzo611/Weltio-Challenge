package com.weltio.demo.service.impl;

import com.weltio.demo.dto.OrderDto;
import com.weltio.demo.exception.NotFoundException;
import com.weltio.demo.mapper.OrderMapper;
import com.weltio.demo.model.Order;
import com.weltio.demo.repository.OrderRepository;
import com.weltio.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto save(OrderDto order) {
        Order orderJpa = OrderMapper.mapToEntity(order);
        return OrderMapper.mapToDto(orderRepository.save(orderJpa));
    }

    @Override
    public String delete(Long id) throws NotFoundException {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return "Deleted order";
        }
        throw new NotFoundException("The order don't exists");
    }

    @Override
    public OrderDto update(Long id,OrderDto order) throws NotFoundException {
        Order orderJpa = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("The order don't exists"));
        orderJpa.setProducts(order.getProducts());
        return OrderMapper.mapToDto(orderRepository.save(orderJpa));
    }

}
