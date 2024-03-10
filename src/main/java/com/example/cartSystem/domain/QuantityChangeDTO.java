package com.example.cartSystem.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QuantityChangeDTO {

    private Long quantity;

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
