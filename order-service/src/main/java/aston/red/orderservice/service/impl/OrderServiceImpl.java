package aston.red.orderservice.service.impl;

import aston.red.orderservice.dto.OrderDto;
import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.OrderPreparedToPayDto;
import aston.red.orderservice.dto.ProductDtoWithQuantity;
import aston.red.orderservice.entity.Order;
import aston.red.orderservice.exception.OrderNotFoundException;
import aston.red.orderservice.feign.DeliveryFeign;
import aston.red.orderservice.feign.StoreFeign;
import aston.red.orderservice.mapper.OrderMapper;
import aston.red.orderservice.repository.OrderRepository;
import aston.red.orderservice.service.OrderService;
import aston.red.orderservice.service.OrdersGoodsService;
import lombok.Data;
import org.postgresql.util.PSQLException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final DeliveryFeign deliveryFeign;
    private final StoreFeign storeFeign;
    private final OrderMapper orderMapper;
    private final OrdersGoodsService ordersGoodsService;

    @Override
    public void postDeliveryOrder(long orderId) {
        Order order = repository.findById(orderId).orElseThrow(
                () -> new OrderNotFoundException(String.valueOf(orderId)));
        OrderDto orderDto = orderMapper.toOrderDto(order);

        orderDto.setShop(storeFeign.getById(order.getShopId()));
        deliveryFeign.postOrderDto(orderDto);
        try {
            repository.setPaid(orderId);
        } catch (Exception ignored) {}

    }

    @Override
    public Order saveOrder(OrderGoodsDto orderGoodsDto) {
        BigDecimal total = BigDecimal.ZERO;
        for(ProductDtoWithQuantity product : orderGoodsDto.getProducts()){
            BigDecimal cost = product.getPrice().multiply(new BigDecimal(product.getQuantity()));
            total = total.add(cost);
        }

        Order order = new Order();
        order.setUserAddress(orderGoodsDto.getUserAddress());
        order.setTotal(total);
        order.setShopId(orderGoodsDto.getStoreId());
        order.setUserId(orderGoodsDto.getUserId());

        return repository.save(order);
    }

    @Override
    public OrderPreparedToPayDto processOrder(OrderGoodsDto orderGoodsDto) {
        Order order = saveOrder(orderGoodsDto);
        ordersGoodsService.saveGoods(order, orderGoodsDto);

        return new OrderPreparedToPayDto(order.getId(), order.getTotal());
    }

    @Override
    public void confirmationDelivery(long orderId) {
        try {
            repository.setDelivery(orderId);
        } catch (Exception ignored) {}
    }
}