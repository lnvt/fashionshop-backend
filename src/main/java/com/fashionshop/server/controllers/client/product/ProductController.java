package com.fashionshop.server.controllers.client.product;

import com.fashionshop.server.models.ListProductModel;
import com.fashionshop.server.repositories.ListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/product")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ListProductRepository listProductRepository;

    @GetMapping("/list-product")
    public ResponseEntity<List<ListProductModel>> getAllListProduct(){
        List<ListProductModel> listProductModels = new ArrayList<ListProductModel>();
        listProductRepository.findAll().forEach(listProductModels::add);
        return new ResponseEntity<>(listProductModels, HttpStatus.OK);
    }
}
