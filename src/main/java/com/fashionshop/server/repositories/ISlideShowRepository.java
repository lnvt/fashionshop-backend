package com.fashionshop.server.repositories;

import com.fashionshop.server.models.SlideShowModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISlideShowRepository extends JpaRepository<SlideShowModel, Long> {
}
