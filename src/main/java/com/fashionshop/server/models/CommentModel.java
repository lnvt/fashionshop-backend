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

    private Long fkAccountComment;

    private Long fkPostComment;

}
