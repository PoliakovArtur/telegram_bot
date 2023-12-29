package aston.red.orderservice.service;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.entity.Order;

public interface OrdersGoodsService {

    void saveGoods(Order order, OrderGoodsDto orderGoodsDto);
  void patchOrdersGoodsShortsDtoByOrderId(Long orderId);

}
