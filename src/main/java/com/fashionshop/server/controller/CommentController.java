package com.fashionshop.server.controller;

import com.fashionshop.server.models.CommentModel;
import com.fashionshop.server.services.Interface.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/comment")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    private ICommentService commentService;


    @GetMapping
    public ResponseEntity<Iterable<CommentModel>> getAllComment() {
        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentModel> getComment(@PathVariable Long id) {
        Optional<CommentModel> commentModelOptional = commentService.findById(id);
        return commentModelOptional.map(comment -> new ResponseEntity<>(comment, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CommentModel> createComment(@RequestBody CommentModel comment) {
        return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentModel> updateComment(@PathVariable Long id, @RequestBody CommentModel comment) {
        Optional<CommentModel> commentModelOptional = commentService.findById(id);
        return commentModelOptional.map(item -> {
            comment.setCommentId(item.getCommentId());
            return new ResponseEntity<>(commentService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentModel> deleteComment(@PathVariable Long id) {
        Optional<CommentModel> commentModelOptional = commentService.findById(id);
        return commentModelOptional.map(comment -> {
            commentService.remove(id);
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
