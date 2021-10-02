package com.fashionshop.server.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "product_id")
    private Long productId;

    private String productName;

    private String productDescription;

    private String productCost;

    private Long productQuantity;

    private Boolean productStatus;

    @ManyToOne
    @JoinColumn(name = "fk_list_product")
    private ListProductModel fkListProduct;

    @ManyToOne
    @JoinColumn(name = "fk_image_product")
    private ImageModel fkImageProduct;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "cart_product",
            joinColumns = { @JoinColumn( name = "product_id", referencedColumnName = "product_id") },
            inverseJoinColumns = { @JoinColumn( name = "cart_id", referencedColumnName = "cart_id") })
    private Set< CartModel > carts = new HashSet<>();

    public Set<CartModel> getCartModel(){
        return carts;
    }
}
