package com.example.orderservice.controller;

import com.example.orderservice.VO.Customer;
import com.example.orderservice.VO.ReponseTemplateVO;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order-cus")
public class OrderCusomerController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<ReponseTemplateVO> findAllWithCus() {
        List<ReponseTemplateVO> list = new ArrayList<>();
        orderRepository.findAll().forEach(order -> {
            Customer cus = customerService.findOrderWithCustomer(order.getCustomerId());
            list.add(new ReponseTemplateVO(order, cus));
        });
        return list;
    }
}
