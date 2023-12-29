package aston.red.storeservice.exception_handler;

import aston.red.storeservice.dto.ErrorTransferDto;
import aston.red.storeservice.exception.NotFoundStoreException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundStoreException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorTransferDto notFoundStoreException(NotFoundStoreException exception) {
        return ErrorTransferDto.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .errorMessage(exception.getMessage())
                .build();
    }
}
