package com.fashionshop.server.services.Cart;

import com.fashionshop.server.models.CartModel;
import com.fashionshop.server.repositories.ICartRepository;
import com.fashionshop.server.services.Interface.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Override
    public Iterable<CartModel> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<CartModel> findById(long id) {
        return cartRepository.findById(id);
    }

    @Override
    public CartModel save(CartModel cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void remove(Long id) {
        cartRepository.deleteById(id);
    }
}
