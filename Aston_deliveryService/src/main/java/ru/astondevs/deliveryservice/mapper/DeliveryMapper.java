package ru.astondevs.deliveryservice.mapper;

import org.springframework.stereotype.Component;
import ru.astondevs.deliveryservice.dto.courier.CourierDto;
import ru.astondevs.deliveryservice.dto.enums.DeliveryPriority;
import ru.astondevs.deliveryservice.dto.enums.DeliveryStatus;
import ru.astondevs.deliveryservice.dto.order.OrderDto;
import ru.astondevs.deliveryservice.entity.Delivery;

import java.time.LocalDateTime;

@Component
public class DeliveryMapper {

    public Delivery createDelivery(OrderDto orderDto, CourierDto courierDto) {
        return Delivery.builder()
                .deliveryStatus(DeliveryStatus.IN_PROGRESS)
                .deliveryPriority(DeliveryPriority.MEDIUM)
                .deliveryTimeCreation(LocalDateTime.now())
                .orderId(orderDto.getId())
                .courierId(courierDto.getId())
                .tgChatClientId(orderDto.getTgChatIdClient())
                .tgChatCourierId(Long.valueOf(courierDto.getChatId()))
                .build();
    }
}
