package com.fashionshop.server.controller;

import com.fashionshop.server.models.SlideShowModel;
import com.fashionshop.server.services.Interface.ISlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/slide-show")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SlideShowController {

    @Autowired
    private ISlideShowService slideShowService;

    @GetMapping
    public ResponseEntity<Iterable<SlideShowModel>> getAllSlideShow() {
        return new ResponseEntity<>(slideShowService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlideShowModel> getSlideShow(@PathVariable Long id) {
        Optional<SlideShowModel> slideShowModelOptional = slideShowService.findById(id);
        return slideShowModelOptional.map(slideShow -> new ResponseEntity<>(slideShow, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SlideShowModel> createSlideShow(@RequestBody SlideShowModel slideShow) {
        return new ResponseEntity<>(slideShowService.save(slideShow), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlideShowModel> updateSlideShow(@PathVariable Long id, @RequestBody SlideShowModel slideShow) {
        Optional<SlideShowModel> slideShowModelOptional = slideShowService.findById(id);
        return slideShowModelOptional.map(item -> {
            slideShow.setSlideShowId(item.getSlideShowId());
            return new ResponseEntity<>(slideShowService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SlideShowModel> deleteSlideShow(@PathVariable Long id) {
        Optional<SlideShowModel> slideShowModelOptional = slideShowService.findById(id);
        return slideShowModelOptional.map(item -> {
            slideShowService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
