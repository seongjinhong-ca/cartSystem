package com.example.cartSystem;

import com.example.cartSystem.domain.Carts;
import com.example.cartSystem.repository.CartRepository;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CartTest {

    @Autowired
    private CartRepository cartRepository;


    @Test
    public Carts addCart(){
//        Carts cart = new Carts();
//        cart.setQuantity(2L);
//        cart.setProduct_id(1L);
//        cart.setUser_id(1L);
            Carts cart = Carts.builder()
                    .quantity(2L)
                    .user_id(1L)
                    .product_id(1L)
                    .build();

        Carts savedCart = cartRepository.save(cart);


        return savedCart;
    }


}
