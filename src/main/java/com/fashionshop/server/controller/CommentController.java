package com.fashionshop.server.controller;


import com.fashionshop.server.models.CommentModel;
import com.fashionshop.server.repositories.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/comment")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    private ICommentRepository commentRepository;

    @GetMapping
    public List<CommentModel> getAllAccount() {
        return commentRepository.findAll();
    }

    @GetMapping("/{id}")
    public CommentModel getAccount(@PathVariable Long id) {
        return commentRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentModel comment) {
        CommentModel commentCreate = commentRepository.save(comment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(commentCreate.getCommentId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentModel> updateAccount(@PathVariable Long id, @RequestBody CommentModel comment) {
        CommentModel accountModelUpdate = commentRepository.save(comment);
        return new ResponseEntity<CommentModel>(comment, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        commentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
