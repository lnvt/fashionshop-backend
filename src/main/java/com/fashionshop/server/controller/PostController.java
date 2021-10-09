package com.fashionshop.server.controller;


import com.fashionshop.server.models.PostModel;
import com.fashionshop.server.services.Interface.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/post")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    @Autowired
    private IPostService postService;

    @GetMapping
    public ResponseEntity<Iterable<PostModel>> getAllPost() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPost(@PathVariable Long id) {
        Optional<PostModel> postModelOptional = postService.findById(id);
        return postModelOptional.map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PostModel> createPost(@RequestBody PostModel post) {
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostModel> updatePost(@PathVariable Long id, @RequestBody PostModel post) {
        Optional<PostModel> postModelOptional = postService.findById(id);
        return postModelOptional.map(item -> {
            post.setPostId(item.getPostId());
            return new ResponseEntity<>(postService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostModel> deletePost(@PathVariable Long id) {
        Optional<PostModel> postModelOptional = postService.findById(id);
        return postModelOptional.map(item -> {
            postService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
