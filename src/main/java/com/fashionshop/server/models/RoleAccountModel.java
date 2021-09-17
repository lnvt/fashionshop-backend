package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "role_account")
public class RoleAccountModel {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    public Long RoleId;

    @Column(name = "role_name")
    public String RoleName;

    @Column(name = "role_status")
    public Boolean RoleStatus;


    public RoleAccountModel(Long roleId, String roleName, Boolean roleStatus) {
        RoleId = roleId;
        RoleName = roleName;
        RoleStatus = roleStatus;
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public Boolean getRoleStatus() {
        return RoleStatus;
    }

    public void setRoleStatus(Boolean roleStatus) {
        RoleStatus = roleStatus;
    }

    @Override
    public String toString() {
        return "RoleAccountModel{" +
                "RoleId=" + RoleId +
                ", RoleName='" + RoleName + '\'' +
                ", RoleStatus=" + RoleStatus +
                '}';
    }
}
