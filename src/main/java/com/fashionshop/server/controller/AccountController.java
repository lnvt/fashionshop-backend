package com.fashionshop.server.controller;


import com.fashionshop.server.dtos.Account.CreateAccountRequest;
import com.fashionshop.server.dtos.Account.GetAccountByIdResponse;
import com.fashionshop.server.dtos.Account.GetAllAccountResponse;
import com.fashionshop.server.models.AccountModel;
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

    @GetMapping("/account")
    public GetAccountByIdResponse getAccountByd(@RequestParam Long accountId)
    {
        return accountService.getAccountById(accountId);
    }

    @PostMapping
    public AccountModel createAccount(@RequestBody CreateAccountRequest createAccountRequest)
    {
        return accountService.createAccount(createAccountRequest);
    }

    @DeleteMapping
    public String deleteAccount(@RequestParam Long accountId)
    {
        return accountService.deleteAccountById(accountId);
    }

    @PutMapping
    public String UpdateAccount()
    {
        return null;
    }

}