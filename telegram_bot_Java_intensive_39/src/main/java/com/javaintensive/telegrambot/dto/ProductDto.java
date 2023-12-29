package com.javaintensive.telegrambot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto {

    private String name;
    private String description;
    @JsonProperty("quantity")
    private Integer limitQuantity;
    private BigDecimal price;
    private Long id;
    private Long storeId;
}
