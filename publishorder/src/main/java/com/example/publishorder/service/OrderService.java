package com.example.publishorder.service;

import com.example.publishorder.controller.OrderInput;
import com.example.publishorder.entities.Order;

public interface OrderService {

    Order publishPlacedOrderMessage(OrderInput order);
}
