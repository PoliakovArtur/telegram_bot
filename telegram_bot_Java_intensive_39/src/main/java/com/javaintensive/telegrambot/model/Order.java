package com.javaintensive.telegrambot.model;

import com.javaintensive.telegrambot.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Long storeId;
    private Long userId;
    private List<Product> products;
    private String userAddress;

}
