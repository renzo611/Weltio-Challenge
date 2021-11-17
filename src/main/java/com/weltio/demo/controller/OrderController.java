package com.weltio.demo.controller;

import com.weltio.demo.dto.OrderDto;
import com.weltio.demo.exception.NotFoundException;
import com.weltio.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> registerOrder(@RequestBody OrderDto orderDto){
        return new ResponseEntity<>(orderService.save(orderDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(orderService.delete(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderDto order) throws NotFoundException {
        return new ResponseEntity<>(orderService.update(id,order),HttpStatus.OK);
    }
}
