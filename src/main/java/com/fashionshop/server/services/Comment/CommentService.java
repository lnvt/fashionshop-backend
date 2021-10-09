package com.fashionshop.server.services.Comment;

import com.fashionshop.server.models.CommentModel;
import com.fashionshop.server.repositories.ICommentRepository;
import com.fashionshop.server.services.Interface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<CommentModel> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentModel> findById(long id) {
        return commentRepository.findById(id);
    }

    @Override
    public CommentModel save(CommentModel commentModel) {
        return commentRepository.save(commentModel);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
