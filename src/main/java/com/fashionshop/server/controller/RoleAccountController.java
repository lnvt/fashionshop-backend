package com.fashionshop.server.controller;

import com.fashionshop.server.dtos.RoleAccount.DropDownRoleAccountResponse;
import com.fashionshop.server.repositories.IRoleAccountRepository;
import com.fashionshop.server.services.RoleAccount.RoleAccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RoleAccountController {

    @Autowired
    private IRoleAccountRepository roleAccountRepository;

    @Autowired
    private RoleAccountServices roleAccountServices;

    @GetMapping("/dropdownroleaccount")
    public List<DropDownRoleAccountResponse> getDropDownList()
    {
        return roleAccountServices.getDropDownRoleAccount();
    }
}
