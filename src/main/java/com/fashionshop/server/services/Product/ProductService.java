package com.fashionshop.server.services.Product;

import com.fashionshop.server.models.ProductModel;
import com.fashionshop.server.repositories.IProductRepository;
import com.fashionshop.server.services.Interface.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<ProductModel> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }
}
