package com.javaintensive.telegrambot.feignclient;

import com.javaintensive.telegrambot.dto.OrderDto;
import com.javaintensive.telegrambot.dto.OrderPreparedToPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "order-service", url = "${order-service.url}")
public interface OrderClient {

    @PostMapping("/order")
    OrderPreparedToPay prepareToPayOrder(@RequestBody OrderDto orderDto);

    @PutMapping("/order/{orderId}")
    void setOrderStatusPaid(@PathVariable Long orderId);

}
