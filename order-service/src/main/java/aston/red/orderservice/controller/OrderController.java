package aston.red.orderservice.controller;

import aston.red.orderservice.dto.OrderGoodsDto;
import aston.red.orderservice.dto.OrderPreparedToPayDto;
import aston.red.orderservice.service.OrderService;
import aston.red.orderservice.service.OrdersGoodsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrdersGoodsService goodsService;

    @PutMapping("/{orderId}")
    public void payedOrder(@PathVariable long orderId) {
        orderService.postDeliveryOrder(orderId);
        goodsService.patchOrdersGoodsShortsDtoByOrderId(orderId);
    }

    @PutMapping("/delivery/{orderId}")
    public void confirmationDelivery(@PathVariable long orderId) {
        orderService.confirmationDelivery(orderId);
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public OrderPreparedToPayDto processOrder(@RequestBody OrderGoodsDto orderGoodsDto) {
        return orderService.processOrder(orderGoodsDto);
    }
}
