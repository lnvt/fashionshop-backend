package com.fashionshop.server.repositories;

import com.fashionshop.server.models.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImageRepository extends JpaRepository<ImageModel, Long> {
}
