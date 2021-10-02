package com.fashionshop.server.controller;

import com.fashionshop.server.dtos.ListProduct.DropdownListProductResponse;
import com.fashionshop.server.repositories.IListProductRepository;
import com.fashionshop.server.services.ListProduct.ListProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ListProductController {

    @Autowired
    private IListProductRepository listProductRepository;

    @Autowired
    private ListProductServices listProductServices;

    @GetMapping("/dropdownlistproduct")
    public List<DropdownListProductResponse> getDropDownList()
    {
        return listProductServices.getDropDownListProduct();
    }
}
