package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "list_product")
public class ListProductModel {

    @Id
    @GeneratedValue
    @Column(name = "list_product_id")
    public Long ListProductId;

    @Column(name = "list_product_name")
    public String ListProductName;

    @Column(name = "list_product_status")
    public Boolean ListProductStatus;

    public ListProductModel(Long listProductId, String listProductName, Boolean listProductStatus) {
        ListProductId = listProductId;
        ListProductName = listProductName;
        ListProductStatus = listProductStatus;
    }

    public Long getListProductId() {
        return ListProductId;
    }

    public void setListProductId(Long listProductId) {
        ListProductId = listProductId;
    }

    public String getListProductName() {
        return ListProductName;
    }

    public void setListProductName(String listProductName) {
        ListProductName = listProductName;
    }

    public Boolean getListProductStatus() {
        return ListProductStatus;
    }

    public void setListProductStatus(Boolean listProductStatus) {
        ListProductStatus = listProductStatus;
    }

    @Override
    public String toString() {
        return "ListProductModel{" +
                "ListProductId=" + ListProductId +
                ", ListProductName='" + ListProductName + '\'' +
                ", ListProductStatus=" + ListProductStatus +
                '}';
    }
}
