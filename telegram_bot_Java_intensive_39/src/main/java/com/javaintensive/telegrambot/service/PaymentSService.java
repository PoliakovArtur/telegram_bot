package com.javaintensive.telegrambot.service;

import com.javaintensive.telegrambot.feignclient.PaymentClient;
import com.javaintensive.telegrambot.model.PaymentData;
import com.javaintensive.telegrambot.model.PaymentApiResponse;
import com.javaintensive.telegrambot.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentSService {

    private final PaymentClient externalPaymentApi;

    @Autowired
    public PaymentSService(PaymentClient externalPaymentApi) {
        this.externalPaymentApi = externalPaymentApi;
    }

    public PaymentApiResponse pay(PaymentData paymentInfo, BigDecimal sum) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setOrderId(paymentInfo.getOrderId());
        paymentDTO.setCardNumber(paymentInfo.getCardNumber());
        paymentDTO.setCustomerName(paymentInfo.getCardholderName());
        paymentDTO.setDateCard(paymentInfo.getDateCard());
        paymentDTO.setCvv(paymentInfo.getCvv());
        paymentDTO.setTotalPrice(sum);
        return externalPaymentApi.doPayment(paymentDTO);
    }
}


