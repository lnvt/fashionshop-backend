package com.fashionshop.server.repositories;

import com.fashionshop.server.models.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuRepository extends JpaRepository<MenuModel, Long> {
}
