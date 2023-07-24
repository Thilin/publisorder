package com.example.publishorder.controller;

import com.example.publishorder.entities.Order;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Data
@Builder
public class OrderInput implements Serializable {


    private String order;
    private String origin;
    private Float total;
    private String createdAt;
    private List<Item> items;

    public Order getOrderEntity(){
        var order = new Order();
        order.setOrder(UUID.randomUUID().toString());
        order.setOrigin(origin);
        order.setTotal(total);
        order.setCreatedAt(createdAt);

        return order;
    }
}
