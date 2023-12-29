package aston.red.orderservice.feign;

import aston.red.orderservice.dto.OrdersGoodsShortsDto;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "goodsFeign", url = "http://localhost:7777/api/goods")
public interface GoodsFeign {

  @PutMapping("/{storeId}")
  void patchOrdersGoodsShorts(@PathVariable Long storeId,
      @RequestBody List<OrdersGoodsShortsDto> ordersGoodsShortsDtoList);

}
