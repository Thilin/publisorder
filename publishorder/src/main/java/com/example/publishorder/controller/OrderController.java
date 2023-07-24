package com.example.publishorder.controller;

import com.example.publishorder.entities.Order;
import com.example.publishorder.repository.OrderRepository;
import com.example.publishorder.service.OrderService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    public OrderController(OrderRepository orderRepository,
                           OrderService orderService){
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @QueryMapping
    public Iterable<Order> orders(){
        return this.orderRepository.findAll();
    }

    @MutationMapping
    public Order publishPlacedOrderMessage(@Argument(name="input") OrderInput orderInput){
        return this.orderService.publishPlacedOrderMessage(orderInput);
    }
}
