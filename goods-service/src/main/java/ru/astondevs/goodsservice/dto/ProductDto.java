package ru.astondevs.goodsservice.dto;

import java.math.BigDecimal;

public record ProductDto(Long id, String name, String description, Integer quantity, BigDecimal price, Long storeId) {
}
