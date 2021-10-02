package com.fashionshop.server.converts.Product;

import com.fashionshop.server.dtos.Product.GetAllProductResponse;
import com.fashionshop.server.models.ProductModel;

public class GetAllProductMapping {
    public static GetAllProductResponse mappingAllProduct(ProductModel productModel)
    {
        GetAllProductResponse getAllProductResponse = new GetAllProductResponse();

        getAllProductResponse.setProductId(productModel.getProductId());
        getAllProductResponse.setProductName(productModel.getProductName());
        getAllProductResponse.setProductCost(productModel.getProductCost());
        getAllProductResponse.setProductStatus(productModel.getProductStatus());
        getAllProductResponse.setProductQuantity(productModel.getProductQuantity());
        getAllProductResponse.setProductDescription(productModel.getProductDescription());

        return getAllProductResponse;
    }
}
