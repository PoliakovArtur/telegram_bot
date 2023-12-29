package aston.red.storeservice.exception;

import lombok.Getter;

@Getter
public class NotFoundStoreException extends RuntimeException {

    private final String message;

    private static final String EXCEPTION_MESSAGE = "Магазин с таким id - %s не найден";

    public NotFoundStoreException(String message) {
        this.message = String.format(EXCEPTION_MESSAGE, message);
    }
}
