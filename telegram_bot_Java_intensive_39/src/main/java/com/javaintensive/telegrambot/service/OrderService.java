package com.javaintensive.telegrambot.service;


import com.javaintensive.telegrambot.dto.OrderDto;
import com.javaintensive.telegrambot.dto.OrderPreparedToPay;
import com.javaintensive.telegrambot.feignclient.OrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderClient orderClient;

    public OrderPreparedToPay prepareToPayOrder(OrderDto orderDto){
        return orderClient.prepareToPayOrder(orderDto);
    }

    public void setOrderStatusPaid(Long orderId){
        orderClient.setOrderStatusPaid(orderId);
    }
}
