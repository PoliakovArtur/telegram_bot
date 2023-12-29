package ru.astondevs.goodsservice.exception;

public class PriceIncorrectException extends RuntimeException{

    public PriceIncorrectException(String message) {
        super(message);
    }
}
