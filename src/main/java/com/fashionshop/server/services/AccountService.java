package com.fashionshop.server.services;

import com.fashionshop.server.models.AccountModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {

    private static List<AccountModel> accountLists = new ArrayList();

//    static{
//        accountLists.add(new AccountModel(1L,"admin","admin",true,new Date()));
//        accountLists.add(new AccountModel(2L,"client","client",true,new Date()));
//        accountLists.add(new AccountModel(3L,"abcxyz","abcxyz",true,new Date()));
//    }

    public List<AccountModel> findAllAccount() {
        return accountLists;
    }

    public AccountModel deleteById(long id) {
        AccountModel account = findById(id);
        if(account == null) return null;
        if(accountLists.remove(account)) return account;
        return null;
    }

    public AccountModel findById(long id) {
//        for(AccountModel account:accountLists) {
//            if(account.getId() == id) {
//                return account;
//            }
//        }
        return null;
    }


}
