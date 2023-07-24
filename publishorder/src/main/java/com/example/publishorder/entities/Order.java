package com.example.publishorder.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @Column(name = "ORD_ORDER")
    private String order;

    @Column(name = "ORD_ORIGIN")
    private String origin;

    @Column(name = "ORD_TOTAL")
    private Float total;

    @Column(name = "ORD_CREATEDAT")
    private String createdAt;
}
