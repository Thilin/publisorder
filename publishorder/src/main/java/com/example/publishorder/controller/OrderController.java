package com.example.publishorder.controller;

import com.example.publishorder.entities.Order;
import com.example.publishorder.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @MutationMapping
    public Order publishPlacedOrderMessage(@Argument(name="input") OrderInput orderInput){
        return this.orderService.publishPlacedOrderMessage(orderInput);
    }
}
