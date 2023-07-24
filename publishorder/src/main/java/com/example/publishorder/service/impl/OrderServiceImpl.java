package com.example.publishorder.service.impl;

import com.example.publishorder.controller.Item;
import com.example.publishorder.controller.OrderInput;
import com.example.publishorder.entities.Order;
import com.example.publishorder.producer.RabbitMQProducer;
import com.example.publishorder.service.OrderService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private RabbitMQProducer producer;

    public OrderServiceImpl(RabbitMQProducer producer){
        this.producer = producer;
    }
    @Override
    public Order publishPlacedOrderMessage(OrderInput orderInput) {
        var order = new Order();
        var items = new ArrayList<Item>();
        order.setOrder(UUID.randomUUID().toString());
        orderInput.getItems().forEach(item -> {
            var totalPerItem = item.getCost()*item.getQty();
            order.setTotal(order.getTotal()+totalPerItem);
            items.add(item);
        });
        order.setCreatedAt(LocalDateTime.now().toString());
        order.setOrigin(orderInput.getOrigin());
        order.setItems(items);

        String message = new Gson().toJson(order);
        producer.sendMessage(message);
        return order;
    }
}
