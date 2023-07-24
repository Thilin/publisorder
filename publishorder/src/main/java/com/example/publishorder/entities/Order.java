package com.example.publishorder.entities;

import lombok.Data;

@Data
public class Order {

    private String order;
    private String origin;
    private Float total;
    private String createdAt;
}
