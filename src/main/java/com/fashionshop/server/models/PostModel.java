package com.fashionshop.server.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class PostModel {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    public Long postId;

    public String postName;

    public String postDescription;

    public Date postTime;

    private Long fkAccountPost;
}
