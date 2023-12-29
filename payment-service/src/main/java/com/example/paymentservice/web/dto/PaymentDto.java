package com.example.paymentservice.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

public class PaymentDto {
    private Long orderId;

    @NotEmpty
    @Pattern(
            regexp = "^\\d{4}(?:\\s?\\d{4}){3}$",
            message = "Номер карты должен состоять из 16 цифр, пробелы допускаются только между блоками в 4 цифры"
    )
    private String cardNumber;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Pattern(
            regexp = "^[A-Za-z]{1,99}( [A-Za-z]{1,99})?$",
            message = "Имя должно состоять латинских символов, не быть менее 2 и более 100 символов"
    )
    private String customerName;

    @NotEmpty
    @Pattern(regexp="^(0[1-9]|1[0-2])\\/(2[4-6])$", message = "формат даты должен быть месяц(01-12)/год[24-26]")
    private String dateCard;

    @NotEmpty
    @Pattern(regexp="^\\d{3}$", message = "CVV код должен состоять из 3 цифр")
    private String cvv;

    private BigDecimal totalPrice;

    public PaymentDto(Long orderId, String cardNumber, String customerName,
                      String dateCard, String cvv, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.cardNumber = cardNumber;
        this.customerName = customerName;
        this.dateCard = dateCard;
        this.cvv = cvv;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateCard() {
        return dateCard;
    }

    public void setDateCard(String dateCard) {
        this.dateCard = dateCard;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
