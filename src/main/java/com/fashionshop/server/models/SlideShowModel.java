package com.fashionshop.server.models;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "slideshow")
public class SlideShowModel {

    @Id
    @GeneratedValue
    @Column( name = "slideshow_id")
    public Long slideShowId;

    public String slideShowTitle;

    public String slideShowDescription;

    private Long fkImageSlideShow;
}
