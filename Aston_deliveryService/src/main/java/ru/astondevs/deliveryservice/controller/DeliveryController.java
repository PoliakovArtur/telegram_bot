package ru.astondevs.deliveryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.astondevs.deliveryservice.dto.order.OrderDto;
import ru.astondevs.deliveryservice.service.DeliveryService;

@RestController
@RequestMapping("/api/v1/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PutMapping("/{id}")
    public ResponseEntity<?> changeDeliveryStatus(@PathVariable("id") Long id) {
        deliveryService.changeDeliveryStatusToCompletedAndSetOrderCompleted(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/order", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void getOrderDto(@RequestBody OrderDto dto) {
        deliveryService.save(dto);
    }
}
