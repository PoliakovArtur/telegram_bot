package com.javaintensive.telegrambot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDtoWithQuantity {

    private String name;
    private String description;
    private Integer limitQuantity;
    private BigDecimal price;
    private Long id;
    private Long storeId;
    private Integer quantity;
}
