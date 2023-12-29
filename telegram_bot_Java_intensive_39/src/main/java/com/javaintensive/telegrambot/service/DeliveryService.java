package com.javaintensive.telegrambot.service;

import com.javaintensive.telegrambot.feignclient.DeliveryClient;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryClient deliveryClient;

    public void closeOrder(Long orderId) {
        deliveryClient.closeOrder(orderId);
    }

}
