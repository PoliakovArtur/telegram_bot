package com.javaintensive.telegrambot.mapper;

import com.javaintensive.telegrambot.dto.StoreDto;
import com.javaintensive.telegrambot.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMapper {
    List<Store> fromDtoList(List<StoreDto> storeDtoList);
}
