package com.fashionshop.server.models;

import lombok.*;


import javax.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class CommentModel {

    @Id
    @GeneratedValue
    @Column( name = "comment_id")
    public Long commentId;

    public String commentDescription;

    public Boolean commentStatus;

    public Date commentTime;

    @ManyToOne
    @JoinColumn(name = "fk_account_comment")
    private AccountModel fkAccountComment;

    @ManyToOne
    @JoinColumn(name = "fk_post_comment")
    private PostModel fkPostComment;

}
