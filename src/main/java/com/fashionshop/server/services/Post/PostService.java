package com.fashionshop.server.services.Post;

import com.fashionshop.server.models.PostModel;
import com.fashionshop.server.repositories.IPostRepository;
import com.fashionshop.server.services.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public Iterable<PostModel> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Optional<PostModel> findById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public PostModel save(PostModel postModel) {
        return postRepository.save(postModel);
    }

    @Override
    public void remove(Long id) {
        postRepository.deleteById(id);
    }
}
