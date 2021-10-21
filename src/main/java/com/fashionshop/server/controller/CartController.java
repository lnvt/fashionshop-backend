package com.fashionshop.server.controller;

import com.fashionshop.server.models.CartModel;
import com.fashionshop.server.repositories.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/cart")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private ICartRepository cartRepository;

    @GetMapping
    public List<CartModel> getAllAccount() {
        return cartRepository.findAll();
    }

    @GetMapping("/{id}")
    public CartModel getAccount(@PathVariable Long id) {
        return cartRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody CartModel cart) {
        CartModel cartCreate = cartRepository.save(cart);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cartCreate.getCartId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartModel> updateAccount(@PathVariable Long id, @RequestBody CartModel cart) {
        CartModel accountModelUpdate = cartRepository.save(cart);
        return new ResponseEntity<CartModel>(cart, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        cartRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}