package com.example.orderservice.controller;

import com.example.orderservice.VO.ReponseTemplateVO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public ReponseTemplateVO getOrderWithCustomer(@PathVariable long id) {
        return orderService.findOrderWithCustomer(id);
    }
}
