package com.example.orderservice.repository;


import com.example.orderservice.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {

}
