package aston.red.orderservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders_goods")
@Data
public class OrderGoodsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "good_id")
  private Long goodId;

  @Column(name = "good_name")
  private String goodName;

  @Column(name = "quantity")
  private Integer quantity;
  
  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

}
