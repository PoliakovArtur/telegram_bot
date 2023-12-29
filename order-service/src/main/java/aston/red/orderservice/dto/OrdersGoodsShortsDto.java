package aston.red.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrdersGoodsShortsDto {

  private long id;
  private long storeId;
  private int quantity;

}
