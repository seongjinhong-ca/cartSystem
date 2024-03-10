package com.example.cartSystem.domain;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Products {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="total")
    private Long total;

    public Long getId() {
        return id;
    }

    public Long getTotal() {
        return total;
    }
}
