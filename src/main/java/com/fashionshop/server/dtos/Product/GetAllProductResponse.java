package com.fashionshop.server.dtos.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetAllProductResponse {

    public Long productId;
    public String productName;
    public String productDescription;
    public String productCost;
    public Long productQuantity;
    public Boolean productStatus;

}
