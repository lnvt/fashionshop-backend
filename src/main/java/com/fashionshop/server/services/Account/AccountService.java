package com.fashionshop.server.services.Account;

import com.fashionshop.server.converts.Account.GetAllAccountMapping;
import com.fashionshop.server.converts.Product.GetAllProductMapping;
import com.fashionshop.server.dtos.Account.GetAllAccountResponse;
import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService  {

    @Autowired
    IAccountRepository accountRepository;

    public List<GetAllAccountResponse> getAllAccount()
    {
        List<AccountModel> accountModels = accountRepository.findAll();
        List<GetAllAccountResponse> getAllAccountResponses = new ArrayList<>();
        accountModels.forEach( item -> {
            GetAllAccountResponse getAllAccountResponse = GetAllAccountMapping.mappingAllAccount(item);
            getAllAccountResponses.add(getAllAccountResponse);
        });
        return getAllAccountResponses;
    }
}
