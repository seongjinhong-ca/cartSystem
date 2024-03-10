package com.example.cartSystem.controller;

import com.example.cartSystem.domain.Carts;
import com.example.cartSystem.domain.Products;
import com.example.cartSystem.domain.QuantityChangeDTO;
import com.example.cartSystem.repository.CartRepository;
import com.example.cartSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/cart/line-items")
    public ResponseEntity<Carts> addCart(@RequestBody Carts cart){
//        System.out.println(cart.getQuantity());
        Carts cartSaved = cartRepository.save(cart);

//        Products product = new Products();

        return ResponseEntity.ok(cartSaved);
    }

    @PostMapping("/product/line-items")
    public ResponseEntity<Products> addProduct(@RequestBody Products product){
//        System.out.println(product.getTotal());
        Products productSaved = productRepository.save(product);

        return ResponseEntity.ok(productSaved);
    }

    @GetMapping("/cart")
    public ResponseEntity<List<Carts>> getAllCarts(){
        List<Carts> carts = cartRepository.findAll();
        return ResponseEntity.ok(carts);
    }

    @PatchMapping("/cart/line-items/{id}")
    public ResponseEntity<Carts> updateQuantityOfProductInCart(@PathVariable Long cartId,
                                                               @RequestBody QuantityChangeDTO quantityChange)
                                                                throws SQLException {

        Optional<Carts> optionalCart = cartRepository.findById(cartId);

        if(optionalCart.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Carts cart = optionalCart.get();
        System.out.println(cart.getQuantity());

        cart.setQuantity(quantityChange.getQuantity());
        Carts savedCart = cartRepository.save(cart);
        return ResponseEntity.ok(savedCart);
    }

//    @PatchMapping("/cart/line-items/{id}")
//    public ResponseEntity<Carts> updateQuantityOfProductInCart(@PathVariable Long cartId,
//                                                               @RequestBody QuantityChangeDTO quantityChange)
//            throws SQLException {
//        // Carts cart = new Carts();
//        // Carts cart = cartRepository.findById(cartId).orElseThrow(() -> new NullPointerException("id does not exist"));
//
//        Optional<Carts> optionalCart = cartRepository.findById(cartId);
//
//        if(optionalCart.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//
//        Carts cart = optionalCart.get();
//        System.out.println(cart.getQuantity());
//
//        cart.setQuantity(quantityChange.getQuantity());
//        Carts savedCart = cartRepository.save(cart);
//        return ResponseEntity.ok(savedCart);
//    }



    @DeleteMapping("/cart/line-items/{id}")
    public ResponseEntity<Carts> deleteCart(@PathVariable Long id){

        Carts cart = cartRepository.findById(id).get();
        cartRepository.delete(cart);

        return ResponseEntity.ok(cart);
    }


}
