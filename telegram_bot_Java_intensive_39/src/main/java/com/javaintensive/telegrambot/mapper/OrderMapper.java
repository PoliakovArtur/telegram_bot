package com.javaintensive.telegrambot.mapper;

import com.javaintensive.telegrambot.dto.OrderDto;
import com.javaintensive.telegrambot.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);
}

