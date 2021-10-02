package com.fashionshop.server.converts.ListProduct;

import com.fashionshop.server.dtos.ListProduct.DropdownListProductResponse;
import com.fashionshop.server.models.ListProductModel;

public class DropDownListMapping {

    public static DropdownListProductResponse mappingDropDownListProduct(ListProductModel listProductModel){

        DropdownListProductResponse dropdownListProductResponse = new DropdownListProductResponse();

        dropdownListProductResponse.setListProductId(listProductModel.getListProductId());
        dropdownListProductResponse.setListProductName(listProductModel.getListProductName());

        return dropdownListProductResponse;
    }
}
