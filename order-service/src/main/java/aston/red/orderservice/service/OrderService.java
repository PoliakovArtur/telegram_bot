package aston.red.orderservice.service;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.OrderPreparedToPayDto;
import aston.red.orderservice.entity.Order;

public interface OrderService {

    void postDeliveryOrder(long orderId);

    Order saveOrder(OrderGoodsDto orderGoodsDto);

    OrderPreparedToPayDto processOrder(OrderGoodsDto orderGoodsDto);

    void confirmationDelivery(long orderId);
}
