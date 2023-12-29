package com.example.paymentservice.web.util;

import com.example.paymentservice.web.controller.exception.BindingException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsUtil {

    private ErrorsUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static StringBuilder returnErrorsToClient(BindingResult bindingResult) {
        StringBuilder errorMsg = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            errorMsg.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage() == null ? error.getCode() : error.getDefaultMessage())
                    .append("; ");
        }

        throw new BindingException(errorMsg.toString());
    }
}
