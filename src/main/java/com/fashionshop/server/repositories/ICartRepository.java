package com.fashionshop.server.repositories;

import com.fashionshop.server.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<CartModel, Long> {
}
