package com.javaintensive.telegrambot.feignclient;

import com.javaintensive.telegrambot.model.PaymentApiResponse;
import com.javaintensive.telegrambot.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "payments", url = "http://localhost:9090")
public interface PaymentClient {

    @PostMapping(path = "/payment", consumes = "application/json",
            produces = "application/json")
    PaymentApiResponse doPayment(@RequestBody PaymentDTO paymentDto);

    @GetMapping(path = "/payment/{orderId}", consumes = "application/json",
            produces = "application/json")
    PaymentApiResponse checkPayment(@PathVariable("orderId") Long orderId);
}


