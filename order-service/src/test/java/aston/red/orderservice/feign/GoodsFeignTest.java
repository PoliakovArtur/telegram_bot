package aston.red.orderservice.feign;

import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@ExtendWith(MockitoExtension.class)
public class GoodsFeignTest {
    @Mock
    private GoodsFeign goodsFeign;

    @Test
    public void testPatchOrdersGoodsShorts() {
        Long storeId = 1L;
        List<OrdersGoodsShortsDto> ordersGoodsShortsDtoList = Collections.singletonList(
                new OrdersGoodsShortsDto(111L, storeId, 10));

        goodsFeign.patchOrdersGoodsShorts(storeId, ordersGoodsShortsDtoList);

        verify(goodsFeign).patchOrdersGoodsShorts(eq(storeId), eq(ordersGoodsShortsDtoList));
    }
}
