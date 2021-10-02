package com.fashionshop.server.services.Product;

import com.fashionshop.server.converts.Product.GetAllProductMapping;
import com.fashionshop.server.dtos.Product.GetAllProductResponse;
import com.fashionshop.server.models.ProductModel;
import com.fashionshop.server.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    IProductRepository productRepository;

    public List<GetAllProductResponse> getAllProduct()
    {
        List<ProductModel> productModelList = productRepository.findAll();
        List<GetAllProductResponse> getAllProductResponses = new ArrayList<>();
        productModelList.forEach( item -> {
            GetAllProductResponse getAllProductResponse = GetAllProductMapping.mappingAllProduct(item);
            getAllProductResponses.add(getAllProductResponse);
        });
        return getAllProductResponses;
    }
}
