package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class OrderGoodsDto {

    private Long storeId;
    private Long userId;
    private List<ProductDtoWithQuantity> products;
    private String userAddress;

}
