package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class MenuModel {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    public Long MenuId;

    @Column(name = "menu_name")
    public String MenuName;

    @Column(name = "menu_order")
    public Long MenuOrder;

    public MenuModel(Long menuId, String menuName, Long menuOrder) {
        MenuId = menuId;
        MenuName = menuName;
        MenuOrder = menuOrder;
    }

    public Long getMenuId() {
        return MenuId;
    }

    public void setMenuId(Long menuId) {
        MenuId = menuId;
    }

    public String getMenuName() {
        return MenuName;
    }

    public void setMenuName(String menuName) {
        MenuName = menuName;
    }

    public Long getMenuOrder() {
        return MenuOrder;
    }

    public void setMenuOrder(Long menuOrder) {
        MenuOrder = menuOrder;
    }

    @Override
    public String toString() {
        return "MenuModel{" +
                "MenuId=" + MenuId +
                ", MenuName='" + MenuName + '\'' +
                ", MenuOrder=" + MenuOrder +
                '}';
    }
}
