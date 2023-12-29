package ru.astondevs.deliveryservice.exception;

public class NotFoundOrderException extends RuntimeException{
    public NotFoundOrderException(String message) {
        super(message);
    }
}
