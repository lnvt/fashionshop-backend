package com.fashionshop.server.dtos.Account;

import lombok.Data;

import java.util.Date;

@Data
public class CreateAccountRequest {

    private Long accountId;
    private String username;
    private String password;
    private Boolean status;
    private Date createdDate = new Date();
    private Long roleId;

}
