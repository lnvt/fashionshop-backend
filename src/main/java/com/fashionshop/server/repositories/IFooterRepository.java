package com.fashionshop.server.repositories;

import com.fashionshop.server.models.FooterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFooterRepository extends JpaRepository<FooterModel, Long> {
}
