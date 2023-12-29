package com.javaintensive.telegrambot.mapper;

import com.javaintensive.telegrambot.dto.UserDto;
import com.javaintensive.telegrambot.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User fromDto(UserDto userDto);
}
