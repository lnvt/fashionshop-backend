package com.fashionshop.server.controller;

import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.services.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/account")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<AccountModel>> getAllAccount() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel> getAccount(@PathVariable Long id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        return accountModelOptional.map(account -> new ResponseEntity<>(account, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<AccountModel> createAccount(@RequestBody AccountModel account) {
        return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountModel> updateAccount(@PathVariable Long id, @RequestBody AccountModel account) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        return accountModelOptional.map(item -> {
            account.setAccountId(item.getAccountId());
            return new ResponseEntity<>(accountService.save(account), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountModel> deleteAccount(@PathVariable Long id) {
        Optional<AccountModel> accountModelOptional = accountService.findById(id);
        return accountModelOptional.map(item -> {
            accountService.remove(id);
            return new ResponseEntity<>(item, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}