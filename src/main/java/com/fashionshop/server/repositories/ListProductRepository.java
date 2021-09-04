package com.fashionshop.server.repositories;

import com.fashionshop.server.models.ListProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListProductRepository extends JpaRepository<ListProductModel, Integer> {

}
