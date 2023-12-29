package aston.red.storeservice.feign;

import aston.red.storeservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// получить адрес у Goods Service
@FeignClient(value = "goodsServiceFeign", url = "http://localhost:7777/api/goods")
public interface GoodsFeignClient {

    @GetMapping("/{storeId}")
    List<ProductDto> getAllGoodsFromStore(@PathVariable("storeId") long storeId);


    @GetMapping("/{storeId}/{goodId}")
    ProductDto getGoodFromStore(@PathVariable("storeId") long storeId,
                                @PathVariable("goodId") long goodId);
}
