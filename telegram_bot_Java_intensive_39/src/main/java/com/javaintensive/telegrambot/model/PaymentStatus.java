package com.javaintensive.telegrambot.model;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PAID("Оплачен"),
    NOT_PAID("Отменен");

    String title;

    PaymentStatus(String title) {
        this.title = title;
    }
}
