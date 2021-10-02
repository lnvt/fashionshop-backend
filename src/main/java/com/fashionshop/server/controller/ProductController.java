package com.fashionshop.server.controller;

import com.fashionshop.server.dtos.Product.GetAllProductResponse;
import com.fashionshop.server.repositories.IProductRepository;
import com.fashionshop.server.services.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/all-product")
    public List<GetAllProductResponse> getAllProduct()
    {
        return  productService.getAllProduct();
    }
}
