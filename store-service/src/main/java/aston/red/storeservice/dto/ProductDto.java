package aston.red.storeservice.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private long id;

    private String name;

    private String description;

    private Integer quantity;

    private BigDecimal price;

    private long storeId;
}
