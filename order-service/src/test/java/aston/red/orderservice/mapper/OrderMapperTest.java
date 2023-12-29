package aston.red.orderservice.mapper;

import aston.red.orderservice.dto.OrderDto;
import aston.red.orderservice.entity.Order;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMapperTest {
    private final GoodMapper goodMapper = Mappers.getMapper(GoodMapper.class);
    private final OrderMapper orderMapper = Mappers.getMapper(OrderMapper.class);

    @Test
    public void testToOrderDtoMapping() {
        long orderId = 1L;

        Order order = new Order();
        order.setId(orderId);
        order.setUserAddress("Address");
        order.setOrderGoods(new ArrayList<>());

        OrderDto orderDto = orderMapper.toOrderDto(order);

        assertEquals(order.getId(), orderDto.getId());
        assertEquals(order.getUserAddress(), orderDto.getAddressClient());
        assertEquals(order.getOrderGoods(), orderDto.getGoods());
    }
}
