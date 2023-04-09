package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "t_products")
@EqualsAndHashCode(exclude = "id")
@ToString(exclude = "order")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")

    private long id;
    private String name;
    private double cost;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    @JsonIgnoreProperties("products")
    private Order order;
}
