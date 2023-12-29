package com.javaintensive.telegrambot.model;

import lombok.Getter;

@Getter
public class PaymentData {
    private String cardNumber;
    private String cardholderName;
    private String dateCard;
    private String cvv;
    private Long orderId;

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
