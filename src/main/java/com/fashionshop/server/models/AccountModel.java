package com.fashionshop.server.models;

import lombok.*;


import javax.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account", schema = "")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "account_id")
    private Long accountId;

    private String username;

    private String password;

    private Boolean status;

    private Date createdDate;

    private Long fkRoleAccount;

}
