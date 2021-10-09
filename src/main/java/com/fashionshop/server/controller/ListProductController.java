package com.fashionshop.server.controller;


import com.fashionshop.server.models.ListProductModel;
import com.fashionshop.server.services.ListProduct.ListProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/listproduct")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ListProductController {

    @Autowired
    private ListProductServices listProductServices;

    @GetMapping
    public ResponseEntity<Iterable<ListProductModel>> getAllListProduct() {
        return new ResponseEntity<>(listProductServices.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListProductModel> getListProduct(@PathVariable Long id) {
        Optional<ListProductModel> listProductModelOptional = listProductServices.findById(id);
        return listProductModelOptional.map(listProduct -> new ResponseEntity<>(listProduct, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ListProductModel> createListProduct(@RequestBody ListProductModel listProduct) {
        return new ResponseEntity<>(listProductServices.save(listProduct), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListProductModel> updateListProduct(@PathVariable Long id, @RequestBody ListProductModel listProduct) {
        Optional<ListProductModel> listProductModelOptional = listProductServices.findById(id);
        return listProductModelOptional.map(item -> {
            listProduct.setListProductId(item.getListProductId());
            return new ResponseEntity<>(listProductServices.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListProductModel> deleteListProduct(@PathVariable Long id) {
        Optional<ListProductModel> listProductModelOptional = listProductServices.findById(id);
        return listProductModelOptional.map(listProduct -> {
            listProductServices.remove(id);
            return new ResponseEntity<>(listProduct, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
