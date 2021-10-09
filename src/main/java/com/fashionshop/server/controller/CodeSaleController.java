package com.fashionshop.server.controller;

import com.fashionshop.server.models.CodeSaleModel;
import com.fashionshop.server.services.Interface.ICodeSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/codesale")
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
    public ResponseEntity<CodeSaleModel> getCodeSale(@PathVariable Long id) {
        Optional<CodeSaleModel> codeSaleModelOptional = codeSaleService.findById(id);
        return codeSaleModelOptional.map(codeSale -> new ResponseEntity<>(codeSale, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CodeSaleModel> createCodeSale(@RequestBody CodeSaleModel codeSale) {
        return new ResponseEntity<>(codeSaleService.save(codeSale), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CodeSaleModel> updateCodeSale(@PathVariable Long id, @RequestBody CodeSaleModel codeSale) {
        Optional<CodeSaleModel> codeSaleModelOptional = codeSaleService.findById(id);
        return codeSaleModelOptional.map(item -> {
            codeSale.setCodeSaleId(item.getCodeSaleId());
            return new ResponseEntity<>(codeSaleService.save(codeSale), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CodeSaleModel> deleteCodeSale(@PathVariable Long id) {
        Optional<CodeSaleModel> codeSaleModelOptional = codeSaleService.findById(id);
        return codeSaleModelOptional.map(item -> {
            codeSaleService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
