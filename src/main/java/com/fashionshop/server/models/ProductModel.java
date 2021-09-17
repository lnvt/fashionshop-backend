package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductModel {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    public Long ProductId;

    @Column(name = "product_name")
    public String ProductName;

    @Column(name = "product_cost")
    public String ProductCost;

    @Column(name = "product_status")
    public Boolean ProductStatus;

    @Column(name = "product_quantity")
    public Long ProductQuantity;

    @Column(name = "product_description")
    public String ProductDescription;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "list_product_id")
    public ListProductModel fkListProduct;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    public PaymentModel fkPaymentProduct;

    public ProductModel(Long productId, String productName, String productCost, Boolean productStatus, Long productQuantity, String productDescription, ListProductModel fkListProduct, PaymentModel fkPaymentProduct) {
        ProductId = productId;
        ProductName = productName;
        ProductCost = productCost;
        ProductStatus = productStatus;
        ProductQuantity = productQuantity;
        ProductDescription = productDescription;
        this.fkListProduct = fkListProduct;
        this.fkPaymentProduct = fkPaymentProduct;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductCost() {
        return ProductCost;
    }

    public void setProductCost(String productCost) {
        ProductCost = productCost;
    }

    public Boolean getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        ProductStatus = productStatus;
    }

    public Long getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductQuantity(Long productQuantity) {
        ProductQuantity = productQuantity;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public ListProductModel getFkListProduct() {
        return fkListProduct;
    }

    public void setFkListProduct(ListProductModel fkListProduct) {
        this.fkListProduct = fkListProduct;
    }

    public PaymentModel getFkPaymentProduct() {
        return fkPaymentProduct;
    }

    public void setFkPaymentProduct(PaymentModel fkPaymentProduct) {
        this.fkPaymentProduct = fkPaymentProduct;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "ProductId=" + ProductId +
                ", ProductName='" + ProductName + '\'' +
                ", ProductCost='" + ProductCost + '\'' +
                ", ProductStatus=" + ProductStatus +
                ", ProductQuantity=" + ProductQuantity +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", fkListProduct=" + fkListProduct +
                ", fkPaymentProduct=" + fkPaymentProduct +
                '}';
    }
}
