package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class GoodDto {
    private Long id;
    private String name;
    private int quantity;
}
