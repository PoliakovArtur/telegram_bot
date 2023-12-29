package com.example.paymentservice.web.dto;

import com.example.paymentservice.app.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {
    @NonNull
    private PaymentStatus status;
    @NonNull
    private Long orderId;
    private String date;
    private BigDecimal price;

    public ResponseDto(@NonNull PaymentStatus status, @NonNull Long orderId) {
        this.status = status;
        this.orderId = orderId;
    }

    public ResponseDto(@NonNull PaymentStatus status, @NonNull Long orderId, String date, BigDecimal price) {
        this.status = status;
        this.orderId = orderId;
        this.date = date;
        this.price = price;
    }

    @NonNull
    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(@NonNull PaymentStatus status) {
        this.status = status;
    }

    @NonNull
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(@NonNull Long orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
