package com.example.orderservice.VO;

import com.example.orderservice.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseTemplateVO {
    private Order order;
    private Customer customer;
}
