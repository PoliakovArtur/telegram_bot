package ru.astondevs.goodsservice.service;

import org.springframework.data.domain.PageRequest;
import ru.astondevs.goodsservice.dto.ProductDto;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<ProductDto> readAll(Long storeId, PageRequest pageRequest);

    ProductDto readById(Long storeId, Long id);

    ProductDto sellProduct(Long storeId, Long id, ProductDto productDto);

    Map<Long, String> sellProducts(Long storeId, List<ProductDto> productsDto);
}
