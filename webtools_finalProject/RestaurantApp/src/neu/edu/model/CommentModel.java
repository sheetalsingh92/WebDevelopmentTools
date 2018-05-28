/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author shaurabh
 */
public class CommentModel {
    private Integer commentId;
    private Integer reviewId;
    private String userName;
    private String commentDesc;
    private Set<RepliesModel> replieses = new HashSet<>(0);


    public CommentModel(){}
    public CommentModel(Integer commentId, Integer reviewId, String userName, String commentDesc) {
        this.commentId = commentId;
        this.reviewId = reviewId;
        this.userName = userName;
        this.commentDesc = commentDesc;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentDesc() {
        return commentDesc;
    }

    public void setCommentDesc(String commentDesc) {
        this.commentDesc = commentDesc;
    }

    public Set<RepliesModel> getReplieses() {
        return replieses;
    }

    public void setReplieses(Set<RepliesModel> replieses) {
        this.replieses = replieses;
    }
}
