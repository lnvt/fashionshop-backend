package com.fashionshop.server.controller;

import com.fashionshop.server.models.ProductModel;
import com.fashionshop.server.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {


    @Autowired
    private IProductRepository productRepository;

    @GetMapping("/product")
    public List<ProductModel> getAllProduct() {
        return productRepository.findAll();
    }

    @GetMapping("/detail/product/{id}")
    public ProductModel getProduct(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping("/detail/{id}")
    public ProductModel getDetailProduct(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductModel product) {
        ProductModel productCreate = productRepository.save(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productCreate.getProductId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel product) {
        ProductModel productUpdate = productRepository.save(product);
        return new ResponseEntity<ProductModel>(product, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



}
