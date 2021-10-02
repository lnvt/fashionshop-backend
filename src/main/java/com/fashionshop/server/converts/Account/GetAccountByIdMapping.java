package com.fashionshop.server.converts.Account;

import com.fashionshop.server.dtos.Account.GetAccountByIdResponse;
import com.fashionshop.server.models.AccountModel;

public class GetAccountByIdMapping {

    public static GetAccountByIdResponse mappingGetAccountById(AccountModel accountModel)
    {
        GetAccountByIdResponse getAccountByIdResponse = new GetAccountByIdResponse();

        getAccountByIdResponse.setAccountId(accountModel.getAccountId());
        getAccountByIdResponse.setUsername(accountModel.getUsername());
        getAccountByIdResponse.setPassword(accountModel.getPassword());
        getAccountByIdResponse.setCreatedDate(accountModel.getCreatedDate());

        return getAccountByIdResponse;
    }
}
