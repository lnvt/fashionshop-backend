package com.fashionshop.server.controller;

import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/account")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {


    @Autowired
    private IAccountRepository accountRepository;

    @GetMapping
    public List<AccountModel> getAllAccount() {
        return accountRepository.findAll();
    }

    @GetMapping("/{id}")
    public AccountModel getAccount(@PathVariable Long id) {
       return accountRepository.findById(id).get();
    }

    @PostMapping()
    public ResponseEntity<Void> createAccount(@RequestBody AccountModel account) {
        AccountModel accountCreate = accountRepository.save(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(accountCreate.getAccountId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountModel> updateAccount(@PathVariable Long id, @RequestBody AccountModel account) {
        AccountModel accountModelUpdate = accountRepository.save(account);
        return new ResponseEntity<AccountModel>(account, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}