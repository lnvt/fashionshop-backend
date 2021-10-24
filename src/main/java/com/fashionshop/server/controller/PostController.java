package com.fashionshop.server.controller;


import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.models.PostModel;
import com.fashionshop.server.repositories.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/post")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    @Autowired
    private IPostRepository postRepository;

    @GetMapping
    public List<PostModel> getAllPost() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public PostModel getPost(@PathVariable Long id) {
        return postRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostModel post) {
        PostModel postCreate = postRepository.save(post);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postCreate.getPostId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostModel> updatePost(@PathVariable Long id, @RequestBody PostModel post) {
        PostModel postModelUpdate = postRepository.save(post);
        return new ResponseEntity<PostModel>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
