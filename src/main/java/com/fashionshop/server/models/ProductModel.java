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

    private Long fkListProduct;

    private String fkImageProduct;

}
