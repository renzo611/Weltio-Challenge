package com.weltio.demo.service;

import com.weltio.demo.dto.OrderDto;
import com.weltio.demo.exception.NotFoundException;
import com.weltio.demo.model.Order;
import com.weltio.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto save(OrderDto order) {
        Order orderJpa = OrderDto.mapToEntity(order);
        return OrderDto.mapToDto(orderRepository.save(orderJpa));
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
        return OrderDto.mapToDto(orderRepository.save(orderJpa));
    }

}
