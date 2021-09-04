package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "list_product")
public class ListProductModel {

    public ListProductModel(){}

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListProductModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
