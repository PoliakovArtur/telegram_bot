package com.javaintensive.telegrambot.feignclient;

import com.javaintensive.telegrambot.dto.ProductDto;
import com.javaintensive.telegrambot.dto.StoreDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "store-service", url = "${store-service.url}")
public interface StoreClient {

    @GetMapping("/store")
    List<StoreDto> getAllStores();

    @GetMapping("/store/{storeId}")
    List<ProductDto> getGoodsByStoreId(@PathVariable Long storeId);

}
