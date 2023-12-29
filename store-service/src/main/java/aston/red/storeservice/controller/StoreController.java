package aston.red.storeservice.controller;

import aston.red.storeservice.dto.ProductDto;
import aston.red.storeservice.dto.StoreDto;
import aston.red.storeservice.dto.StoreToOrderDto;
import aston.red.storeservice.feign.GoodsFeignClient;
import aston.red.storeservice.mapper.StoreMapper;
import aston.red.storeservice.service.StoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/store", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Tag(name = "Store-service", description = "Сервис магазина")
public class StoreController {

    private final StoreService service;
    private final GoodsFeignClient goodsFeignClient;


    @GetMapping
    public List<StoreDto> getAll() {
        return StoreMapper.INSTANCE.fromAllStoreToAllDto(service.getAll());
    }

    @GetMapping(path = "/{storeId}")
    public List<ProductDto> getByIdWithAllProducts(@PathVariable("storeId") long storeId) {
        List<ProductDto> list = goodsFeignClient.getAllGoodsFromStore(storeId);
        return list;
    }

    @GetMapping(path = "/{storeId}/{productId}")
    public ProductDto getByIdWithProduct(@PathVariable("storeId") long storeId,
                                         @PathVariable("productId") long productId) {
        return goodsFeignClient.getGoodFromStore(storeId, productId);
    }

    @GetMapping(path = "/transfer/{storeId}")
    public StoreToOrderDto getToOrderService(@PathVariable("storeId") long storeId) {
        return StoreMapper.INSTANCE.fromStoreToOrderService(service.getById(storeId));
    }
}
