package com.javaintensive.telegrambot.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private String name;
    private String description;
    private Integer limitQuantity;
    private BigDecimal price;
    private Long id;
    private Long storeId;
    private int quantity;

}
