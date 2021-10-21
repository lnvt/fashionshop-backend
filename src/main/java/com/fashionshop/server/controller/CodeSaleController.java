package com.fashionshop.server.controller;

import com.fashionshop.server.models.CodeSaleModel;
import com.fashionshop.server.repositories.ICodeSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/codesale")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CodeSaleController {

    @Autowired
    private ICodeSaleRepository codeSaleRepository;

    @GetMapping
    public List<CodeSaleModel> getAllCodeSale() {
        return codeSaleRepository.findAll();
    }

    @GetMapping("/{id}")
    public CodeSaleModel getAccount(@PathVariable Long id) {
        return codeSaleRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createCodeSale(@RequestBody CodeSaleModel codeSale) {
        CodeSaleModel codeSaleCreate = codeSaleRepository.save(codeSale);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(codeSaleCreate.getCodeSaleId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeSaleModel> updateAccount(@PathVariable Long id, @RequestBody CodeSaleModel codeSale) {
        CodeSaleModel codeSaleUpdate = codeSaleRepository.save(codeSale);
        return new ResponseEntity<CodeSaleModel>(codeSale, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        codeSaleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
