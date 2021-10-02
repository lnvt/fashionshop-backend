package com.fashionshop.server.models;


import lombok.*;

import javax.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image")
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "image_id")
    public Long imageId;

    public String imageName;

    public String imagePath;

    @OneToMany(mappedBy = "fkImageSlideShow")
    private List<SlideShowModel> SlideShow;

    @OneToMany(mappedBy = "fkImageProduct")
    private List<ProductModel> Product;
}
