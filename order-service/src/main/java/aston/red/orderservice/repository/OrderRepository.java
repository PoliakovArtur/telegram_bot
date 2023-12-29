package aston.red.orderservice.repository;

import aston.red.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(long orderId);

    @Modifying
    @Query(value = "UPDATE orders SET paid = true WHERE id = ?", nativeQuery = true)
    void setPaid(long orderId);

    @Modifying
    @Query(value = "UPDATE orders SET delivery = true WHERE id = ?", nativeQuery = true)
    void setDelivery(long orderId);
}
