package ru.astondevs.deliveryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ru.astondevs.deliveryservice.dto.courier.CourierDto;

@FeignClient(value = "courierClient", url = "http://localhost:8081/aston/user-service/users/courier")
public interface CourierFeignClient {

    @GetMapping
    CourierDto findFreeCourier();
}
