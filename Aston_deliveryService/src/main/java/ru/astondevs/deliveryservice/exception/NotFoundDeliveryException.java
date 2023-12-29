package ru.astondevs.deliveryservice.exception;

public class NotFoundDeliveryException extends RuntimeException {
    public NotFoundDeliveryException(String message) {
        super(message);
    }
}