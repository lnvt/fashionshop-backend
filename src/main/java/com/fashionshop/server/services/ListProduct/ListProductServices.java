package com.fashionshop.server.services.ListProduct;

import com.fashionshop.server.converts.ListProduct.DropDownListMapping;
import com.fashionshop.server.dtos.ListProduct.DropdownListProductResponse;
import com.fashionshop.server.models.ListProductModel;
import com.fashionshop.server.repositories.IListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListProductServices {

    @Autowired
    IListProductRepository listProductRepository;

    public List<DropdownListProductResponse> getDropDownListProduct()
    {
        List<ListProductModel> listProductModels = listProductRepository.findAll();
        List<DropdownListProductResponse> dropdownListProductResponses = new ArrayList<>();
        listProductModels.forEach( item -> {
            DropdownListProductResponse dropdownListProductResponse = DropDownListMapping.mappingDropDownListProduct(item);
            dropdownListProductResponses.add(dropdownListProductResponse);
        });

        return dropdownListProductResponses;
    }
}
