package com.fashionshop.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;


import java.util.Date;
import java.util.Set;
import java.util.HashSet;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class CartModel {

    @Id
    @GeneratedValue
    @Column( name = "cart_id")
    private Long cartId;

    private String cartName;

    private Date cartDate;

    private Long fkPaymentCart;

    private Long fkProductCart;
}
