package com.javaintensive.telegrambot.model;

import com.javaintensive.telegrambot.model.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PaymentApiResponse {
    private PaymentStatus status;
    private Long orderId;
    private String date;
    private BigDecimal price;


}
