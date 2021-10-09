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
    public Long slideshowId;

    public String slideshowTitle;

    public String slideshowDescription;

    private Long fkImageSlideshow;
}
