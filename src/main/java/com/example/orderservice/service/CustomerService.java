package com.example.orderservice.service;


import com.example.orderservice.VO.Customer;
import com.example.orderservice.VO.ReponseTemplateVO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {
    @Autowired
    private RestTemplate restTemplate;


    @Retry(name = "basicRetry", fallbackMethod = "fallBackMethod")
    @RateLimiter(name = "basicRate", fallbackMethod = "fallBackMethod")
    public Customer findOrderWithCustomer(long id) {
        return restTemplate.getForObject(
                "https://cus-cus-order.herokuapp.com/customers/" + id, Customer.class);
    }

    private Customer fallBackMethod(RuntimeException exception) {
        return new Customer(null, "loi", exception.getMessage());
    }

}
