package com.fashionshop.server.models;

import javax.persistence.*;

@Entity
@Table(name = "footer")
public class FooterModel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long Id;

    @Column(name = "name")
    public String Name;

    @Column(name = "description")
    public String Description;

    public FooterModel(Long id, String name, String description) {
        Id = id;
        Name = name;
        Description = description;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "FooterModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
