package com.fashionshop.server.controller;

import com.fashionshop.server.models.CartModel;
import com.fashionshop.server.repositories.ICartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    @Autowired
    private ICartRepository cartRepository;

    @GetMapping("/cart")
    public List<CartModel> getAllAccount() {
        return cartRepository.findAll();
    }
}