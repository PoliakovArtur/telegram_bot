package com.javaintensive.telegrambot.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PaymentDTO {
    private Long orderId;

    @Pattern(
            regexp = "^\\d{4}(?:\\s?\\d{4}){3}$",
            message = "Номер карты должен состоять из 16 цифр, пробелы допускаются только между блоками в 4 цифры"
    )
    private String cardNumber;

    @Pattern(
            regexp = "^[A-Za-z]{1,99}( [A-Za-z]{1,99})?$",
            message = "Имя должно состоять латинских символов, не быть менее 2 и более 100 символов"
    )
    private String customerName;

    @Pattern(regexp="^(0[1-9]|1[0-2])\\/(2[4-6])$", message = "формат даты должен быть месяц(01-12)/год[24-26]")
    private String dateCard;

    @Pattern(regexp="^\\d{3}$", message = "CVV код должен состоять из 3 цифр")
    private String cvv;

    private BigDecimal totalPrice;

}
