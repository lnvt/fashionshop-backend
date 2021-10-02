package com.fashionshop.server.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "footer")
public class FooterModel {

    @Id
    @GeneratedValue
    @Column( name = "id")
    public Long id;

    public String name;

    public String description;


}
