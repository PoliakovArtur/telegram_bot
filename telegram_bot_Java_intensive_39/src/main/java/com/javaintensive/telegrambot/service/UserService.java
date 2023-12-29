package com.javaintensive.telegrambot.service;

import com.javaintensive.telegrambot.dto.UserDto;
import com.javaintensive.telegrambot.feignclient.UserClient;
import com.javaintensive.telegrambot.mapper.UserMapper;
import com.javaintensive.telegrambot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserClient userClient;
    private final UserMapper mapper;
    public void save(User user) {
        UserDto dto = mapper.toDto(user);
        userClient.save(dto);
    }

    public Optional<User> findById(long chatId) {
        ResponseEntity<UserDto> response = userClient.findById(chatId);
        return Optional.ofNullable(response.getStatusCode().isError() ? null : mapper.fromDto(response.getBody()));
    }
}
