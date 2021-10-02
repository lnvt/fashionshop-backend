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

    @ManyToOne
    @JoinColumn(name = "fk_payment_cart")
    private PaymentModel fkPaymentCart;

    @ManyToMany(mappedBy = "carts", cascade = { CascadeType.ALL })
    @JsonIgnore
    private Set<ProductModel> product = new HashSet<ProductModel>();
}
