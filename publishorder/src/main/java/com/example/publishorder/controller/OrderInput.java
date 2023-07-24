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

    private String origin;
    private List<Item> items;
}
