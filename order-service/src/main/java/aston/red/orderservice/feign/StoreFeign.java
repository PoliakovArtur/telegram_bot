package aston.red.orderservice.feign;

import aston.red.orderservice.dto.StoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "storeFeign", url = "http://localhost:8888/store")
public interface StoreFeign {

    @GetMapping("/transfer/{id}")
    StoreDto getById(@PathVariable("id") long storeId);
}
