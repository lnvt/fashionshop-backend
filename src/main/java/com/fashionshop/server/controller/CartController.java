package com.fashionshop.server.controller;

import com.fashionshop.server.models.CartModel;
import com.fashionshop.server.services.Interface.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/cart")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private ICartService cartService;

    @GetMapping
    public ResponseEntity<Iterable<CartModel>> getAllCart() {
        return new ResponseEntity<>(cartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartModel> getCart(@PathVariable Long id) {
        Optional<CartModel> cartModelOptional = cartService.findById(id);
        return cartModelOptional.map(item -> new ResponseEntity<>(item, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CartModel> createCart(@RequestBody CartModel cart) {
        return new ResponseEntity<>(cartService.save(cart), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartModel> updateCart(@PathVariable Long id, @RequestBody CartModel cart) {
        Optional<CartModel> cartModelOptional = cartService.findById(id);
        return cartModelOptional.map(item -> {
            cart.setCartId(item.getCartId());
            return new ResponseEntity<>(cartService.save(cart), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CartModel> deleteCart(@PathVariable Long id) {
        Optional<CartModel> cartModelOptional = cartService.findById(id);
        return cartModelOptional.map(cart -> {
            cartService.remove(id);
            return new ResponseEntity<>(cart, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}