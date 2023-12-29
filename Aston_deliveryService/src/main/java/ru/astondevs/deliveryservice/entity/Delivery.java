package ru.astondevs.deliveryservice.entity;

import jakarta.persistence.*;
import lombok.*;
import ru.astondevs.deliveryservice.dto.enums.DeliveryPriority;
import ru.astondevs.deliveryservice.dto.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "delivery_priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryPriority deliveryPriority;

    @Column(name = "courier_id", nullable = false)
    private UUID courierId;

    @Column(name = "tg_chat_client_id", nullable = false)
    private Long tgChatClientId;

    @Column(name = "tg_chat_courier_id", nullable = false)
    private Long tgChatCourierId;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Column(name = "delivery_time_creation", nullable = false)
    private LocalDateTime deliveryTimeCreation;
}
