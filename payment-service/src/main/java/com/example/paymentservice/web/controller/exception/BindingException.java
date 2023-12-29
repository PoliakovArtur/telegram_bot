package com.example.paymentservice.web.controller.exception;

public class BindingException extends RuntimeException {
    public BindingException(String msg) {
        super(msg);
    }
}
