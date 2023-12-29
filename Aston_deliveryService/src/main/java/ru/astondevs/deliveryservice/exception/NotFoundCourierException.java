package ru.astondevs.deliveryservice.exception;

public class NotFoundCourierException extends RuntimeException{
    public NotFoundCourierException(String message) {
        super(message);
    }
}
