package ru.astondevs.deliveryservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.astondevs.deliveryservice.client.CourierFeignClient;
import ru.astondevs.deliveryservice.client.OrderFeignClient;
import ru.astondevs.deliveryservice.client.TelegramFeignClient;
import ru.astondevs.deliveryservice.dto.courier.CourierDto;
import ru.astondevs.deliveryservice.dto.enums.DeliveryStatus;
import ru.astondevs.deliveryservice.dto.message.MessageDto;
import ru.astondevs.deliveryservice.dto.order.OrderDto;
import ru.astondevs.deliveryservice.entity.Delivery;
import ru.astondevs.deliveryservice.exception.*;
import ru.astondevs.deliveryservice.mapper.DeliveryMapper;
import ru.astondevs.deliveryservice.repository.DeliveryRepository;
import ru.astondevs.deliveryservice.util.DeliveryUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final CourierFeignClient courierClient;
    private final OrderFeignClient orderClient;
    private final TelegramFeignClient telegramClient;
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    @Transactional
    public void save(OrderDto orderDto) {
        if (orderDto == null) {
            throw new NotFoundOrderException("Order not found");
        }

        validateAlreadyExists(orderDto);

        CourierDto courierDto = courierClient.findFreeCourier();

        if (courierDto == null) {
            throw new NotFoundCourierException("Courier not found");
        }

        Delivery delivery = deliveryMapper.createDelivery(orderDto, courierDto);

        Delivery savedDeliveryEntity = deliveryRepository.save(delivery);

        sendMessageToTgChatIdForCourier(orderDto, savedDeliveryEntity);
        sendMessageToTgChatIdForClient(orderDto, savedDeliveryEntity);
    }

    @Transactional
    public void changeDeliveryStatusToCompletedAndSetOrderCompleted(Long deliveryId) {
        Delivery delivery = deliveryRepository.findByOrderId(deliveryId)
                .orElseThrow(() -> new NotFoundDeliveryException(String.format("Delivery with id = %s not found ", deliveryId)));

        changeOrderStatusToCompleted(delivery.getOrderId());

        try {
            changeDeliveryStatusToCompleted(delivery.getId());
        } catch (Exception e) {
            throw new DeliveryStatusChangeException(String.format("Failed to change delivery status, deliveryId = %s", deliveryId));
        }
    }

    private void changeDeliveryStatusToCompleted(Long deliveryId) {
        deliveryRepository.changeDeliveryStatus(DeliveryStatus.COMPLETED, deliveryId);
    }

    private void changeOrderStatusToCompleted(Long orderId) {
        orderClient.changeOrderStatusToCompleted(orderId);
    }

    private void sendMessageToTgChatIdForClient(OrderDto orderDto, Delivery delivery) {
        if (delivery == null) {
            throw new NotFoundDeliveryException("Delivery not found");
        }
        String messageForClient = DeliveryUtil.createMessageForClient(orderDto, delivery);
        telegramClient.sendMessageToTgChatClient(delivery.getTgChatClientId(), new MessageDto(messageForClient, orderDto.getId()));
    }

    private void sendMessageToTgChatIdForCourier(OrderDto orderDto, Delivery delivery) {
        if (delivery == null) {
            throw new NotFoundDeliveryException("Delivery not found");
        }
        String messageForCourier = DeliveryUtil.createMessageForCourier(orderDto, delivery);
        telegramClient.sendMessageToTgChatCourier(delivery.getTgChatCourierId(), new MessageDto(messageForCourier, orderDto.getId()));
    }

    private void validateAlreadyExists(OrderDto orderDto) {
        Optional<Delivery> deliveryByOrderId = deliveryRepository.findByOrderId(orderDto.getId());

        if (deliveryByOrderId.isPresent()) {
            throw new DuplicateException(String.format("Order with id = %s already exist", orderDto.getId()));
        }
    }
}
