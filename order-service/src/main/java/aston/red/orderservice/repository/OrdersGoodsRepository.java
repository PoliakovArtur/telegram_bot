package aston.red.orderservice.repository;

import aston.red.orderservice.entity.OrderGoodsEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersGoodsRepository extends JpaRepository<OrderGoodsEntity, Long> {
  List<OrderGoodsEntity> findOrderGoodsEntitiesByOrderId(Long orderId);
}
