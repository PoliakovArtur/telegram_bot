package aston.red.orderservice.mapper;

import aston.red.orderservice.dto.GoodDto;
import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import aston.red.orderservice.entity.OrderGoodsEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class GoodMapperTest {

    private final GoodMapper goodMapper = Mappers.getMapper(GoodMapper.class);

    @Test
    public void testToGoodDtoMapping() {
        OrderGoodsEntity entity = new OrderGoodsEntity();
        entity.setGoodName("Sample Good");

        GoodDto goodDto = goodMapper.toGoodDto(entity);

        assertEquals(entity.getGoodName(), goodDto.getName());
    }

    @Test
    public void testToOrdersGoodsShortsDtoMapping() {
        OrderGoodsEntity orderGoodsEntity = new OrderGoodsEntity();
        orderGoodsEntity.setGoodId(123L);

        OrdersGoodsShortsDto ordersGoodsShortsDto = goodMapper.toOrdersGoodsShortsDto(orderGoodsEntity);

        assertNotNull(ordersGoodsShortsDto);
        assertEquals(orderGoodsEntity.getGoodId(), ordersGoodsShortsDto.getId());
    }
}