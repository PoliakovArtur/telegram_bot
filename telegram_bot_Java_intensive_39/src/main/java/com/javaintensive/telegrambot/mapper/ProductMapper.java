package com.javaintensive.telegrambot.mapper;

import com.javaintensive.telegrambot.dto.ProductDto;
import com.javaintensive.telegrambot.dto.ProductDtoWithQuantity;
import com.javaintensive.telegrambot.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<Product> fromDtoList(List<ProductDto> productDtoList);

    List<ProductDtoWithQuantity> toDtoList(List<Product> productList);
}
