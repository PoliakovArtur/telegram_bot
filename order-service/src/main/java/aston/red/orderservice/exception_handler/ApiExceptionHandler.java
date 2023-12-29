package aston.red.orderservice.exception_handler;

import aston.red.orderservice.dto.ErrorTransferDto;
import aston.red.orderservice.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorTransferDto orderNotFoundException(OrderNotFoundException exception) {

        return ErrorTransferDto.builder()
                .errorCode(HttpStatus.NOT_FOUND.value())
                .errorMessage(exception.getMessage())
                .build();
    }
}
