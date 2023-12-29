package ru.astondevs.deliveryservice.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private Long tgChatIdClient;
    private String addressClient;
    private List<GoodDto> goods = new ArrayList<>();
    private StoreDto shop;

    public String getGoodsNamesAndQuantities(List<GoodDto> goodsDto) {
        return goodsDto.stream()
                .map(good -> good.getName() + " - " + good.getQuantity())
                .collect(Collectors.joining(",\n"));
    }
}
