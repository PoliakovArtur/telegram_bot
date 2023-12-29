package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class OrderDto {
    private Long id;
    private Long tgChatIdClient;
    private String addressClient;
    private List<GoodDto> goods;
    private StoreDto shop;
}