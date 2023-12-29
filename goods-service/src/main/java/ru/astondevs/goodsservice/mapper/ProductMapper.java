package ru.astondevs.goodsservice.mapper;

import org.mapstruct.Mapper;
import ru.astondevs.goodsservice.dto.ProductDto;
import ru.astondevs.goodsservice.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto toDto(Product entity);

    Product toEntity(ProductDto dto);

    List<ProductDto> toDtoList(List<Product> entityList);

    List<Product> toEntityList(List<ProductDto> dtoList);
}
