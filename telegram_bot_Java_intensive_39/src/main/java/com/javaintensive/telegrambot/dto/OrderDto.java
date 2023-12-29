package com.javaintensive.telegrambot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class OrderDto {

    private Long storeId;
    private List<ProductDtoWithQuantity> products;
    private String userAddress;
    private Long userId;
}
