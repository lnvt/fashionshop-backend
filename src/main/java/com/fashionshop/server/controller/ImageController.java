package com.fashionshop.server.controller;


import com.fashionshop.server.models.ImageModel;
import com.fashionshop.server.services.Interface.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/image")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<Iterable<ImageModel>> getAllImage() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageModel> getImage(@PathVariable Long id) {
        Optional<ImageModel> imageModelOptional = imageService.findById(id);
        return imageModelOptional.map(image -> new ResponseEntity<>(image, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ImageModel> createImage(@RequestBody ImageModel image) {
        return new ResponseEntity<>(imageService.save(image), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageModel> updateImage(@PathVariable Long id, @RequestBody ImageModel image) {
        Optional<ImageModel> imageModelOptional = imageService.findById(id);
        return imageModelOptional.map(item -> {
            image.setImageId(item.getImageId());
            return new ResponseEntity<>(imageService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImageModel> deleteImage(@PathVariable Long id) {
        Optional<ImageModel> imageModelOptional = imageService.findById(id);
        return imageModelOptional.map(item -> {
            imageService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
