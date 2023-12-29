package com.javaintensive.telegrambot.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "delivery", url = "${delivery-service.url}")
public interface DeliveryClient {

    @PutMapping("/api/v1/deliveries/{id}")
    void closeOrder(@PathVariable Long id);
}
