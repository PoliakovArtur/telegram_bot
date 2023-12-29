package com.javaintensive.telegrambot.feignclient;

import com.javaintensive.telegrambot.dto.OrderDto;
import com.javaintensive.telegrambot.dto.OrderPreparedToPay;
import com.javaintensive.telegrambot.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserClient {

    @PostMapping("/aston/user-service/users/create")
    void save(UserDto userDto);

    @GetMapping("/aston/user-service/users/{chatId}")
    ResponseEntity<UserDto> findById(@PathVariable long chatId);
}