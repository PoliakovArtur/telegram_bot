package aston.red.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "user_address", nullable = false)
  private String userAddress;

  @Column(name = "paid")
  private boolean paid;

  @Column(name = "total")
  private BigDecimal total;

  @Column(name = "shop_id", nullable = false)
  private Long shopId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "delivery")
  private boolean delivery;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<OrderGoodsEntity> orderGoods;
}
