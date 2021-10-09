package com.fashionshop.server.services.Account;

import com.fashionshop.server.models.AccountModel;
import com.fashionshop.server.repositories.IAccountRepository;
import com.fashionshop.server.services.Interface.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService  implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Iterable<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<AccountModel> findById(long id) {
        return accountRepository.findById(id);
    }

    @Override
    public AccountModel save(AccountModel account) {
        return accountRepository.save(account);
    }

    @Override
    public void remove(Long id) {
        accountRepository.deleteById(id);
    }

}
