package com.fashionshop.server.controller;


import com.fashionshop.server.models.ProductModel;
import com.fashionshop.server.services.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/product")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<ProductModel>> getAllProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProduct(@PathVariable Long id) {
        Optional<ProductModel> productModelOptional = productService.findById(id);
        return productModelOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductModel> createProduct(@RequestBody ProductModel product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel product) {
        Optional<ProductModel> productModelOptional = productService.findById(id);
        return productModelOptional.map(item -> {
            product.setProductId(item.getProductId());
            return new ResponseEntity<>(productService.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductModel> deleteProduct(@PathVariable Long id) {
        Optional<ProductModel> productModelOptional = productService.findById(id);
        return productModelOptional.map(item -> {
            productService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
