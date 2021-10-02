package com.fashionshop.server.models;

import lombok.*;

import javax.persistence.*;

import java.util.List;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role_account", schema = "public")
public class RoleAccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "role_id")
    private Long roleId;

    private String roleName;

    private Boolean roleStatus;

    @OneToMany(mappedBy = "fkRoleAccount")
    private List<AccountModel> Account;
}
