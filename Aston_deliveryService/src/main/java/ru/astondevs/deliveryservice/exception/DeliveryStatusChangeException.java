package ru.astondevs.deliveryservice.exception;

public class DeliveryStatusChangeException extends RuntimeException{
    public DeliveryStatusChangeException(String message) {
        super(message);
    }
}
