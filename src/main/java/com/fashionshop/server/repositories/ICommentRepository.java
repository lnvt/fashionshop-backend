package com.fashionshop.server.repositories;

import com.fashionshop.server.models.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends JpaRepository<CommentModel, Long> {
}
