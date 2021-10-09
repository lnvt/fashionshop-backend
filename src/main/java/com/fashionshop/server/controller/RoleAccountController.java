package com.fashionshop.server.controller;

import com.fashionshop.server.models.RoleAccountModel;
import com.fashionshop.server.services.RoleAccount.RoleAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RequestMapping("/api/role-account")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleAccountController {

    @Autowired
    private RoleAccountServices roleAccountServices;

    @GetMapping
    public ResponseEntity<Iterable<RoleAccountModel>> getAllRoleAccount() {
        return new ResponseEntity<>(roleAccountServices.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleAccountModel> getRoleAccount(@PathVariable Long id) {
        Optional<RoleAccountModel> roleAccountModelOptional = roleAccountServices.findById(id);
        return roleAccountModelOptional.map(roleAccount -> new ResponseEntity<>(roleAccount, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<RoleAccountModel> createRoleAccount(@RequestBody RoleAccountModel roleAccount) {
        return new ResponseEntity<>(roleAccountServices.save(roleAccount), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleAccountModel> updateRoleAccount(@PathVariable Long id, @RequestBody RoleAccountModel roleAccount) {
        Optional<RoleAccountModel> roleAccountModelOptional = roleAccountServices.findById(id);
        return roleAccountModelOptional.map(item -> {
            roleAccount.setRoleId(item.getRoleId());
            return new ResponseEntity<>(roleAccountServices.save(item), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleAccountModel> deleteRoleAccount(@PathVariable Long id) {
        Optional<RoleAccountModel> roleAccountModelOptional = roleAccountServices.findById(id);
        return roleAccountModelOptional.map(roleAccount -> {
            roleAccountServices.remove(id);
            return new ResponseEntity<>(roleAccount, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
