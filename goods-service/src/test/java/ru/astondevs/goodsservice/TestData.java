package ru.astondevs.goodsservice;

import ru.astondevs.goodsservice.dto.ProductDto;
import ru.astondevs.goodsservice.model.Product;

import java.math.BigDecimal;

public final class TestData {

    private TestData() {
    }

    public static Product getProduct1() {
        return new Product(1L, "Book1", "Description for Book1", 10, BigDecimal.valueOf(19.99), 1L);
    }

    public static Product getProduct2() {
        return new Product(2L, "Book2", "Description for Book2", 20, BigDecimal.valueOf(29.99), 1L);
    }

    public static Product getProduct3() {
        return new Product(3L, "Book3", "Description for Book3", 30, BigDecimal.valueOf(39.99), 1L);
    }

    public static ProductDto getProductDto1() {
        return new ProductDto(1L, "Book1", "Description for Book1", 10, BigDecimal.valueOf(19.99), 1L);
    }

    public static ProductDto getProductDto2() {
        return new ProductDto(2L, "Book2", "Description for Book2", 20, BigDecimal.valueOf(29.99), 1L);
    }

    public static ProductDto getProductDto3() {
        return new ProductDto(3L, "Book3", "Description for Book3", 30, BigDecimal.valueOf(39.99), 1L);
    }
}
