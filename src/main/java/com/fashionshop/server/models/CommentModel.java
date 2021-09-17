package com.fashionshop.server.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentModel {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    public Long CommentId;

    @Column(name = "comment_description")
    public String CommentDescription;

    @Column(name = "comment_status")
    public Boolean CommentStatus;

    @Column(name = "account_id")
    public Date CommentTime;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "account_id")
    public AccountModel fkAccountComment;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "post_id")
    public PostModel fkPostComment;

    public CommentModel(Long commentId, String commentDescription, Boolean commentStatus, Date commentTime, AccountModel fkAccountComment, PostModel fkPostComment) {
        CommentId = commentId;
        CommentDescription = commentDescription;
        CommentStatus = commentStatus;
        CommentTime = commentTime;
        this.fkAccountComment = fkAccountComment;
        this.fkPostComment = fkPostComment;
    }

    public Long getCommentId() {
        return CommentId;
    }

    public void setCommentId(Long commentId) {
        CommentId = commentId;
    }

    public String getCommentDescription() {
        return CommentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        CommentDescription = commentDescription;
    }

    public Boolean getCommentStatus() {
        return CommentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        CommentStatus = commentStatus;
    }

    public Date getCommentTime() {
        return CommentTime;
    }

    public void setCommentTime(Date commentTime) {
        CommentTime = commentTime;
    }

    public AccountModel getFkAccountComment() {
        return fkAccountComment;
    }

    public void setFkAccountComment(AccountModel fkAccountComment) {
        this.fkAccountComment = fkAccountComment;
    }

    public PostModel getFkPostComment() {
        return fkPostComment;
    }

    public void setFkPostComment(PostModel fkPostComment) {
        this.fkPostComment = fkPostComment;
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "CommentId=" + CommentId +
                ", CommentDescription='" + CommentDescription + '\'' +
                ", CommentStatus=" + CommentStatus +
                ", CommentTime=" + CommentTime +
                ", fkAccountComment=" + fkAccountComment +
                ", fkPostComment=" + fkPostComment +
                '}';
    }


}
