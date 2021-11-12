package com.example.orderservice.service;


import com.example.orderservice.VO.Customer;
import com.example.orderservice.VO.ReponseTemplateVO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Order saveOrder(Order users) {
        return orderRepository.save(users);
    }


    public ReponseTemplateVO findOrderWithCustomer(long id) {
        ReponseTemplateVO vo = new ReponseTemplateVO();
        Order order = orderRepository.findById(id).get();
        vo.setOrder(order);
        Customer customer =restTemplate.getForObject("http://localhost:9001/customers/"+order.getCustomerId(),Customer.class);
        vo.setCustomer(customer);
        return vo;
    }

}
