package com.fashionshop.server.controller;


import com.fashionshop.server.models.RoleAccountModel;
import com.fashionshop.server.repositories.IRoleAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/role-account")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleAccountController {

    @Autowired
    private IRoleAccountRepository roleAccountRepository;

    @GetMapping
    public List<RoleAccountModel> getAllRoleAccount() {
        return roleAccountRepository.findAll();
    }

    @GetMapping("/{id}")
    public RoleAccountModel getRoleAccount(@PathVariable Long id) {
        return roleAccountRepository.findById(id).get();
    }

    @PostMapping
    public ResponseEntity<Void> createRoleAccount(@RequestBody RoleAccountModel account) {
        RoleAccountModel accountCreate = roleAccountRepository.save(account);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(accountCreate.getRoleId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleAccountModel> updateRoleAccount(@PathVariable Long id, @RequestBody RoleAccountModel account) {
        RoleAccountModel accountModelUpdate = roleAccountRepository.save(account);
        return new ResponseEntity<RoleAccountModel>(account, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoleAccount(@PathVariable Long id) {
        roleAccountRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
