package com.fashionshop.server.models;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class SlideShowModel {

    @Id
    @GeneratedValue
    @Column(name = "slideshow_id")
    public Long SlideShowId;

    @Column(name = "slideshow_title")
    public String SlideShowTitle;

    @Column(name = "slideshow_description")
    public String SlideShowDescription;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "image_id")
    public ImageModel fkImageSlideShow;

    public SlideShowModel(Long slideShowId, String slideShowTitle, String slideShowDescription, ImageModel fkImageSlideShow) {
        SlideShowId = slideShowId;
        SlideShowTitle = slideShowTitle;
        SlideShowDescription = slideShowDescription;
        this.fkImageSlideShow = fkImageSlideShow;
    }

    public Long getSlideShowId() {
        return SlideShowId;
    }

    public void setSlideShowId(Long slideShowId) {
        SlideShowId = slideShowId;
    }

    public String getSlideShowTitle() {
        return SlideShowTitle;
    }

    public void setSlideShowTitle(String slideShowTitle) {
        SlideShowTitle = slideShowTitle;
    }

    public String getSlideShowDescription() {
        return SlideShowDescription;
    }

    public void setSlideShowDescription(String slideShowDescription) {
        SlideShowDescription = slideShowDescription;
    }

    public ImageModel getFkImageSlideShow() {
        return fkImageSlideShow;
    }

    public void setFkImageSlideShow(ImageModel fkImageSlideShow) {
        this.fkImageSlideShow = fkImageSlideShow;
    }

    @Override
    public String toString() {
        return "SlideShowModel{" +
                "SlideShowId=" + SlideShowId +
                ", SlideShowTitle='" + SlideShowTitle + '\'' +
                ", SlideShowDescription='" + SlideShowDescription + '\'' +
                ", fkImageSlideShow=" + fkImageSlideShow +
                '}';
    }
}
