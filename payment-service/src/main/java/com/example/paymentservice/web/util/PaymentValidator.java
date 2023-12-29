package com.example.paymentservice.web.util;

import com.example.paymentservice.app.service.PaymentService;
import com.example.paymentservice.web.dto.PaymentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.text.ParseException;


@Component
public class PaymentValidator implements Validator {

    private final PaymentService paymentService;

    @Autowired
    public PaymentValidator(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public boolean supports(@NonNull Class<?> aClass) {
        return PaymentDto.class.equals(aClass);
    }

    @Override
    public void validate(@NonNull Object o, @NonNull Errors errors) {
        PaymentDto paymentDto = (PaymentDto) o;

        try {
            if (!paymentService.checkDate(paymentDto))
                errors.rejectValue("dateCard", "", "Срок действия карты истек");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
