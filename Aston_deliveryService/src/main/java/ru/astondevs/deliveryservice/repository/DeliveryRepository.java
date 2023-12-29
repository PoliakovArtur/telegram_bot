package ru.astondevs.deliveryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.astondevs.deliveryservice.dto.enums.DeliveryStatus;
import ru.astondevs.deliveryservice.entity.Delivery;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("""
            UPDATE Delivery d 
            SET d.deliveryStatus = :status 
            WHERE d.id = :deliveryId""")
    void changeDeliveryStatus(@Param("status") DeliveryStatus status, @Param("deliveryId") Long deliveryId);
    Optional<Delivery> findByOrderId(Long orderId);
}
