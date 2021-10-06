package com.fashionshop.server.controller;

import com.fashionshop.server.models.CodeSaleModel;
import com.fashionshop.server.repositories.ICodeSaleRepository;
import com.fashionshop.server.services.Interface.ICodeSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/codesale/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CodeSaleController {

    @Autowired
    private ICodeSaleService codeSaleService;

    @GetMapping
    public ResponseEntity<Iterable<CodeSaleModel>> getAllCodeSale() {
        return new ResponseEntity<>(codeSaleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CodeSaleModel> getCategory(@PathVariable Long id) {
        Optional<CodeSaleModel> categoryOptional = codeSaleService.findById(id);
        return categoryOptional.map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CodeSaleModel> createNewCodeSale(@RequestBody CodeSaleModel codeSale) {
        return new ResponseEntity<>(codeSaleService.save(codeSale), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeSaleModel> updateCodeSale(@PathVariable Long id, @RequestBody CodeSaleModel codeSale) {
        Optional<CodeSaleModel> codeSaleOptional = codeSaleService.findById(id);
        return codeSaleOptional.map(category1 -> {
            codeSale.setCodeSaleId(category1.getCodeSaleId());
            return new ResponseEntity<>(codeSaleService.save(codeSale), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CodeSaleModel> deleteCategory(@PathVariable Long id) {
        Optional<CodeSaleModel> codeSaleOptional = codeSaleService.findById(id);
        return codeSaleOptional.map(category -> {
            codeSaleService.remove(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
