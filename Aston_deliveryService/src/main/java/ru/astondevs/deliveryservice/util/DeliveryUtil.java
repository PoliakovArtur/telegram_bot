package ru.astondevs.deliveryservice.util;

import ru.astondevs.deliveryservice.dto.order.OrderDto;
import ru.astondevs.deliveryservice.entity.Delivery;

public final class DeliveryUtil {

    public static String createMessageForCourier(OrderDto orderDto, Delivery delivery) {
        String shopAddress = orderDto.getShop().getAddress();
        String shopPhone = orderDto.getShop().getPhone();
        String addressClient = orderDto.getAddressClient();
        String nameAndCountGood = orderDto.getGoodsNamesAndQuantities(orderDto.getGoods());
        String deliveryStatus = delivery.getDeliveryStatus().name();
        Long tgChatIdClient = orderDto.getTgChatIdClient();

        return String.format("Address shop: %s, Address client: %s, Phone shop: %s, Good and count good: %s, Priority: %s, Client tgChatId: %s",
                shopAddress, addressClient, shopPhone, nameAndCountGood, deliveryStatus, tgChatIdClient
        );
    }

    public static String createMessageForClient(OrderDto orderDto, Delivery delivery) {
        String addressClient = orderDto.getAddressClient();
        String phoneShop = orderDto.getShop().getPhone();
        String nameAndCountGood = orderDto.getGoodsNamesAndQuantities(orderDto.getGoods());
        Long tgCourierChatId = delivery.getTgChatCourierId();

        return String.format("Address client = %s, Phone shop = %s, Good and count good = %s, Courier tgCourierChatId : %s",
                addressClient, phoneShop, nameAndCountGood, tgCourierChatId
        );
    }

    private DeliveryUtil() {
    }
}
