package com.fashionshop.server.repositories;

import com.fashionshop.server.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<PostModel, Long> {
}
