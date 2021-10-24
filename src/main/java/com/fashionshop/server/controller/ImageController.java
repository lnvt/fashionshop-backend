package com.fashionshop.server.controller;


import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.models.ImageModel;
import com.fashionshop.server.repositories.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/image")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {


    @Autowired
    private IImageRepository imageRepository;

    @GetMapping
    public List<ImageModel> getAllImage() {
        return imageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ImageModel getImage(@PathVariable Long id) {
        return imageRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createImage(@RequestBody ImageModel image) {
        ImageModel imageCreate = imageRepository.save(image);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(imageCreate.getImageId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageModel> updateImage(@PathVariable Long id, @RequestBody ImageModel image) {
        ImageModel imageModel = imageRepository.save(image);
        return new ResponseEntity<ImageModel>(image, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
