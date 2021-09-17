package com.fashionshop.server.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    public Long AccountId;

    @Column(name = "username")
    public String Username;

    @Column(name = "password")
    public String Password;

    @Column(name = "status")
    public Boolean Status;

    @Column(name = "status")
    public Date CreatedDate;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "RoleId")
    public RoleAccountModel fkRoleAccount;

    public AccountModel(Long accountId, String username, String password, Boolean status, Date createdDate, RoleAccountModel fkRoleAccount) {
        AccountId = accountId;
        Username = username;
        Password = password;
        Status = status;
        CreatedDate = createdDate;
        this.fkRoleAccount = fkRoleAccount;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public RoleAccountModel getFkRoleAccount() {
        return fkRoleAccount;
    }

    public void setFkRoleAccount(RoleAccountModel fkRoleAccount) {
        this.fkRoleAccount = fkRoleAccount;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "AccountId=" + AccountId +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Status=" + Status +
                ", CreatedDate=" + CreatedDate +
                ", fkRoleAccount=" + fkRoleAccount +
                '}';
    }
}
