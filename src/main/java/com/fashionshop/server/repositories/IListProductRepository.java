package com.fashionshop.server.repositories;

import com.fashionshop.server.models.ListProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IListProductRepository extends JpaRepository<ListProductModel, Long> {

}
