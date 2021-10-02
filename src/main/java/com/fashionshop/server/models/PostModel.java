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

    @Column(name = "post_name")
    public String postName;

    @Column(name = "post_description")
    public String postDescription;

    @Column(name = "post_time")
    public Date postTime;

    @OneToMany(mappedBy = "fkPostComment")
    private List<CommentModel> comment;

    @ManyToOne
    @JoinColumn(name = "fk_account_post")
    private AccountModel fkAccountPost;
}
