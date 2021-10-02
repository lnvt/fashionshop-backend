package com.fashionshop.server.controller;


import com.fashionshop.server.dtos.Account.GetAllAccountResponse;
import com.fashionshop.server.repositories.IListProductRepository;
import com.fashionshop.server.services.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private IListProductRepository listProductRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping("/all-account")
    public List<GetAllAccountResponse> getAllAccount(){
        return accountService.getAllAccount();
    }
}