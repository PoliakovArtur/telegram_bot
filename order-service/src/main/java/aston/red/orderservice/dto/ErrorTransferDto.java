package aston.red.orderservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorTransferDto {

    private Integer errorCode;
    private String errorMessage;
}
