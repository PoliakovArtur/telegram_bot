package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class OrderPreparedToPayDto {

    private Long orderId;
    private BigDecimal sum;
}
