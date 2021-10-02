package com.fashionshop.server.controller;

import com.fashionshop.server.repositories.ISlideShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SlideShowController {

    @Autowired
    private ISlideShowRepository slideShowRepository;

}
