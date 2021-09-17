package com.fashionshop.server.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class PostModel {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    public Long PostId;

    @Column(name = "post_name")
    public String PostName;

    @Column(name = "post_description")
    public String PostDescription;

    @Column(name = "post_time")
    public Date PostTime;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "account_id")
    public AccountModel fkAccountPost;

    public PostModel(Long postId, String postName, String postDescription, Date postTime, AccountModel fkAccountPost) {
        PostId = postId;
        PostName = postName;
        PostDescription = postDescription;
        PostTime = postTime;
        this.fkAccountPost = fkAccountPost;
    }

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }

    public String getPostName() {
        return PostName;
    }

    public void setPostName(String postName) {
        PostName = postName;
    }

    public String getPostDescription() {
        return PostDescription;
    }

    public void setPostDescription(String postDescription) {
        PostDescription = postDescription;
    }

    public Date getPostTime() {
        return PostTime;
    }

    public void setPostTime(Date postTime) {
        PostTime = postTime;
    }

    public AccountModel getFkAccountPost() {
        return fkAccountPost;
    }

    public void setFkAccountPost(AccountModel fkAccountPost) {
        this.fkAccountPost = fkAccountPost;
    }

    @Override
    public String toString() {
        return "PostModel{" +
                "PostId=" + PostId +
                ", PostName='" + PostName + '\'' +
                ", PostDescription='" + PostDescription + '\'' +
                ", PostTime=" + PostTime +
                ", fkAccountPost=" + fkAccountPost +
                '}';
    }
}
