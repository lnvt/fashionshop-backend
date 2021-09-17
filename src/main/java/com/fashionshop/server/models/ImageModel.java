package com.fashionshop.server.models;


import javax.persistence.*;

@Entity
@Table(name = "image")
public class ImageModel {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    public Long ImageId;

    @Column(name = "image_name")
    public String ImageName;

    @Column(name = "image_path")
    public String ImagePath;

    public ImageModel(Long imageId, String imageName, String imagePath) {
        ImageId = imageId;
        ImageName = imageName;
        ImagePath = imagePath;
    }

    public Long getImageId() {
        return ImageId;
    }

    public void setImageId(Long imageId) {
        ImageId = imageId;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    @Override
    public String toString() {
        return "ImageModel{" +
                "ImageId=" + ImageId +
                ", ImageName='" + ImageName + '\'' +
                ", ImagePath='" + ImagePath + '\'' +
                '}';
    }
}
