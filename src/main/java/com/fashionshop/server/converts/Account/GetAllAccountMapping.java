package com.fashionshop.server.converts.Account;

import com.fashionshop.server.dtos.Account.GetAllAccountResponse;
import com.fashionshop.server.models.AccountModel;

public class GetAllAccountMapping {

    public static GetAllAccountResponse mappingAllAccount(AccountModel accountModel) {

        GetAllAccountResponse getAllAccountResponse = new GetAllAccountResponse();

        getAllAccountResponse.setAccountId(accountModel.getAccountId());
        getAllAccountResponse.setUsername(accountModel.getUsername());
        getAllAccountResponse.setPassword(accountModel.getPassword());
        getAllAccountResponse.setCreatedDate(accountModel.getCreatedDate());

        return getAllAccountResponse;
    }
}
