package com.fashionshop.server.dtos.Account;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class GetAllAccountResponse {

    public Long accountId;
    public String username;
    public String password;
    public Date createdDate;

}
