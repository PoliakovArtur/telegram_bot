package aston.red.orderservice.service;

import aston.red.orderservice.dto.OrderDto;
import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.StoreDto;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.exception.OrderNotFoundException;
import aston.red.orderservice.feign.DeliveryFeign;
import aston.red.orderservice.feign.StoreFeign;
import aston.red.orderservice.mapper.OrderMapper;
import aston.red.orderservice.repository.OrderRepository;
import aston.red.orderservice.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTests {
    @InjectMocks
    private OrderServiceImpl orderService;
    @Mock
    private OrderRepository repository;
    @Mock
    private DeliveryFeign deliveryFeign;
    @Mock
    private StoreFeign storeFeign;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private OrdersGoodsService ordersGoodsService;

    @Test
    void testPostDeliveryOrder() {
        long orderId = 1L;
        long shopId = 1L;

        Order order = new Order();
        order.setId(orderId);
        order.setShopId(shopId);

        OrderDto orderDto = OrderDto.builder()
                .id(orderId)
                .build();

        when(repository.findById(orderId)).thenReturn(Optional.of(order));
        when(orderMapper.toOrderDto(order)).thenReturn(orderDto);
        when(storeFeign.getById(shopId)).thenReturn(new StoreDto(shopId, "StoreName", "8888", "Address"));

        orderService.postDeliveryOrder(orderId);

        verify(repository, times(1)).findById(orderId);
        verify(storeFeign, times(1)).getById(shopId);
        verify(deliveryFeign, times(1)).postOrderDto(orderDto);
    }

    @Test
    public void testPostDeliveryOrder_OrderNotFoundException() {
        long orderId = 123;

        when(repository.findById(orderId)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.postDeliveryOrder(orderId));
    }

    @Test
    void testSaveOrder() {
        OrderGoodsDto orderGoodsDto = OrderGoodsDto.builder()
                .storeId(1L)
                .userId(1L)
                .products(new ArrayList<>())
                .build();

        when(repository.save(any(Order.class))).thenReturn(new Order());

        orderService.saveOrder(orderGoodsDto);

        verify(repository, times(1)).save(any(Order.class));
    }

    @Test
    void testProcessOrder() {
        OrderGoodsDto orderGoodsDto = OrderGoodsDto.builder()
                .storeId(1L)
                .userId(1L)
                .products(new ArrayList<>())
                .build();

        Order order = new Order();
        order.setId(1L);

        when(orderService.saveOrder(orderGoodsDto)).thenReturn(order);
        orderService.processOrder(orderGoodsDto);

        verify(ordersGoodsService, times(1)).saveGoods(order, orderGoodsDto);
    }
}
