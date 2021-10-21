package com.fashionshop.server.controller;

import com.fashionshop.server.models.ListProductModel;
import com.fashionshop.server.repositories.IListProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RequestMapping("/api/listproduct")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ListProductController {

    @Autowired
    private IListProductRepository listProductRepository;

    @GetMapping
    public List<ListProductModel> getAllListProduct() {
        return listProductRepository.findAll();
    }

    @GetMapping("/{id}")
    public ListProductModel getListProduct(@PathVariable Long id) {
        return listProductRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createListProduct(@RequestBody ListProductModel listProduct) {
        ListProductModel listProductCreate = listProductRepository.save(listProduct);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(listProductCreate.getListProductId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListProductModel> updateListProduct(@PathVariable Long id, @RequestBody ListProductModel listProduct) {
        ListProductModel listProductUpdate = listProductRepository.save(listProduct);
        return new ResponseEntity<ListProductModel>(listProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListProduct(@PathVariable Long id) {
        listProductRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
