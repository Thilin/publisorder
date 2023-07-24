package com.example.publishorder.entities;

import com.example.publishorder.controller.Item;
import lombok.Data;

import java.util.List;

@Data
public class Order {

    private String order;
    private String origin;
    private Float total = 0f;
    private String createdAt;
    private List<Item> items;
}
