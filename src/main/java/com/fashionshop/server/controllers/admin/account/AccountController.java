package com.fashionshop.server.controllers.admin.account;

import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.repositories.AccountRepository;
import com.fashionshop.server.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //Get
    @GetMapping("account")
    public List<AccountModel> getAllAccount(){
        return accountService.findAllAccount();
    }

    //Delete
    @DeleteMapping("account/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long id)
    {
        AccountModel account =  accountService.deleteById(id);
        if(account!=null)
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("account/{id}")
    public AccountModel getAccount(@PathVariable long id)
    {
        return accountService.findById(id);
    }
}
