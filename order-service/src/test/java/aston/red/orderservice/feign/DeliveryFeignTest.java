package aston.red.orderservice.feign;

import aston.red.orderservice.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringJUnitConfig
@ExtendWith(MockitoExtension.class)
public class DeliveryFeignTest {

    private final DeliveryFeign deliveryFeign = Mockito.mock(DeliveryFeign.class);

    @Test
    public void testGetOrderDto() {
        long orderId = 1L;
        OrderDto orderDto = OrderDto.builder()
                .id(orderId)
                .build();

        deliveryFeign.postOrderDto(orderDto);

        verify(deliveryFeign, Mockito.times(1)).postOrderDto(Mockito.any());

        ArgumentCaptor<OrderDto> orderDtoCaptor = ArgumentCaptor.forClass(OrderDto.class);
        verify(deliveryFeign).postOrderDto(orderDtoCaptor.capture());

        assertNotNull(orderDtoCaptor.getValue());
    }
}
