package ru.astondevs.goodsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import java.math.BigDecimal;

@Entity
@Table(name = "products", schema = "public")
@Check(constraints = "quantity >= 0")
@Check(constraints = "price >= 0.01")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name", nullable = false)
    String name;
    @Column(name = "description")
    String description;
    @Column(name = "quantity", nullable = false)
    Integer quantity;
    @Column(name = "price", columnDefinition = "decimal", precision = 14, scale = 2)
    BigDecimal price;
    @Column(name = "store_id", nullable = false)
    Long storeId;
}