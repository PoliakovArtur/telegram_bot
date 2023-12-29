package com.javaintensive.telegrambot.service;

import com.javaintensive.telegrambot.dto.ProductDto;
import com.javaintensive.telegrambot.dto.StoreDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final OrderService orderService;
    private final StoreService storeService;

    @GetMapping("/store")
    public List<StoreDto> getAllStores (){
        return storeService.getAllStores();
    }

    @GetMapping("/store/{storeId}")
    public List<ProductDto> getGoodsByStoreId (@PathVariable Long storeId){
        return storeService.getGoodsByStoreId(storeId);
    }

    @PatchMapping("/order/{orderId}")
    public ResponseEntity setOrderStatusPaid(@PathVariable Long orderId){
        System.out.println(orderId);
        orderService.setOrderStatusPaid(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
