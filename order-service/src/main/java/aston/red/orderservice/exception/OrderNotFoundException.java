package aston.red.orderservice.exception;

import lombok.Getter;

@Getter
public class OrderNotFoundException extends RuntimeException {
    private final String message;

    private static final String EXCEPTION_MESSAGE = "Заказ с таким id - %s не найден";

    public OrderNotFoundException(String message) {
        this.message = String.format(EXCEPTION_MESSAGE, message);
    }
}
