package com.fashionshop.server.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class MenuModel {

    @Id
    @GeneratedValue
    @Column( name = "menu_id")
    public Long menuId;

    public String menuName;

    public Long menuOrder;

}
