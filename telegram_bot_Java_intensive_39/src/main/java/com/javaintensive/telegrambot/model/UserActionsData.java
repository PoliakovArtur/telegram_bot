package com.javaintensive.telegrambot.model;

import com.javaintensive.telegrambot.dto.OrderPreparedToPay;
import com.javaintensive.telegrambot.model.Bucket;
import com.javaintensive.telegrambot.model.Store;
import com.javaintensive.telegrambot.model.Order;
import com.javaintensive.telegrambot.model.PaymentData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserActionsData {

    private Bucket bucket;

    private Order order;

    private OrderPreparedToPay orderPreparedToPay;

    private PaymentData paymentInfo;

    private List<Store> storeList;

}
