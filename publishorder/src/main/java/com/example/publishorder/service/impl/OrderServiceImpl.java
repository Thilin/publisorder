package com.example.publishorder.service.impl;

import com.example.publishorder.controller.OrderInput;
import com.example.publishorder.entities.Order;
import com.example.publishorder.producer.RabbitMQProducer;
import com.example.publishorder.service.OrderService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private RabbitMQProducer producer;

    public OrderServiceImpl(RabbitMQProducer producer){
        this.producer = producer;
    }
    @Override
    public Order publishPlacedOrderMessage(OrderInput order) {
        order.setOrder(UUID.randomUUID().toString());
        String message = new Gson().toJson(order);
        producer.sendMessage(message);
        return order.getOrderEntity();
    }
}
