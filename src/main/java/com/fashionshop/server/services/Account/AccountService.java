package com.fashionshop.server.services.Account;

import com.fashionshop.server.converts.Account.GetAccountByIdMapping;
import com.fashionshop.server.converts.Account.GetAllAccountMapping;
import com.fashionshop.server.dtos.Account.CreateAccountRequest;
import com.fashionshop.server.dtos.Account.GetAccountByIdResponse;
import com.fashionshop.server.dtos.Account.GetAllAccountResponse;
import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.repositories.IAccountRepository;
import com.fashionshop.server.repositories.IRoleAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AccountService  {

    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    IRoleAccountRepository roleAccountRepository;

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

    public GetAccountByIdResponse getAccountById(Long accountId)
    {
        Optional<AccountModel> accountModels = accountRepository.findById(accountId);
        if (!accountModels.isPresent())
        {
            log.error("Account is invalid!");
            return null;
        }
        GetAccountByIdResponse getAccountByIdResponse = GetAccountByIdMapping.mappingGetAccountById(accountModels.get());
        return getAccountByIdResponse;
    }

    public AccountModel createAccount(CreateAccountRequest createAccountRequest)
    {
            AccountModel accountModelCreate = new AccountModel();

            accountModelCreate.setAccountId(createAccountRequest.getAccountId());
            accountModelCreate.setCreatedDate(createAccountRequest.getCreatedDate());
            accountModelCreate.setUsername(createAccountRequest.getUsername());
            accountModelCreate.setPassword(createAccountRequest.getPassword());
            accountModelCreate.setStatus(createAccountRequest.getStatus());
            accountModelCreate.setFkRoleAccount(roleAccountRepository.findById(createAccountRequest.getRoleId()).get());

            accountModelCreate = accountRepository.save(accountModelCreate);

            return accountModelCreate;

    }

    public String deleteAccountById(Long accountId)
    {
//        Optional<AccountModel> accountModels = accountRepository.findById(accountId);
//        if (!accountModels.isPresent())
//        {
//            log.error("Account is invalid!");
//            return "Account invalid";
//        }
//        accountModels =  accountRepository.save( accountModels.get().setStatus(true));

        return "OK";
    }
}
