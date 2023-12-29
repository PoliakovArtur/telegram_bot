package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductDtoWithQuantity {

    private Long id;
    private Long storeId;
    private String name;
    private String description;
    private Integer limitQuantity;
    private Integer quantity;
    private BigDecimal price;
}
