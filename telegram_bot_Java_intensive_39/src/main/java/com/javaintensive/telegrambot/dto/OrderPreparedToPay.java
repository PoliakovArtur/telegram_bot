package com.javaintensive.telegrambot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@RequiredArgsConstructor
public class OrderPreparedToPay {

    Long orderId;
    BigDecimal sum;
}
