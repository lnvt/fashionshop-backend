package com.fashionshop.server.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
public class AccountModel {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private Boolean status;
    private Date created_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return "AccountModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", created_date=" + created_date +
                '}';
    }
}
