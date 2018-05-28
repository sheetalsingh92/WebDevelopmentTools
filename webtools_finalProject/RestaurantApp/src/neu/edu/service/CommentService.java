/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.service;

import java.util.ArrayList;
import java.util.List;
import neu.edu.Comments;
import neu.edu.Customer;
import neu.edu.Reviews;
import neu.edu.User;
import neu.edu.dao.CommentDao;
import neu.edu.dao.ReviewDao;
import neu.edu.dao.UserDao;
import neu.edu.model.CommentModel;
import neu.edu.model.RestLogicalErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shaurabh
 */
@Service
public class CommentService {
    @Autowired
    ReviewDao reviewDao;
    
    @Autowired
    UserDao userDao;
    
    @Autowired
    CommentDao commentDao;

    public boolean saveComment(CommentModel commentModel, String username) throws RestLogicalErrorException{
        if (commentModel.getCommentDesc()== null || commentModel.getReviewId()== null) {
            throw new RestLogicalErrorException("Parameters for comment creation are incomplete.");
        }
        Comments comment = new Comments();
        User user = userDao.getUserByName(username);
        Reviews review = reviewDao.getReviewById(commentModel.getReviewId());
        if (user == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. User not found with username: " + username);
        }
        if (review == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. review not found with review ID: " + commentModel.getReviewId());
        }
        comment.setCommentDesc(commentModel.getCommentDesc());
        comment.setReviews(review);
        comment.setUser(user);

        if (!commentDao.saveComment(comment)) {
            throw new RestLogicalErrorException("Create restaurant operation failed. Retaurant already exist.");
        }
        return true;
    }
    
    public List<CommentModel> getCommentList(Integer reviewId) throws RestLogicalErrorException{
        Reviews review = reviewDao.getReviewById(reviewId);
        List<Comments> commentList = commentDao.getCommentList(null, review);
        List<CommentModel> commentModelList = new ArrayList<>();

        if (!commentList.isEmpty()) {
            for (Comments comment : commentList) {
                CommentModel commentModel = new CommentModel(
                        comment.getCommentId(),
                        comment.getReviews().getReviewId(),
                        comment.getUser().getUsername(),
                        comment.getCommentDesc()
                );
//                for(Comments comment: review.getCommentses()){
//                    
//                }
//                reviewModel.setComments();
                commentModelList.add(commentModel);
            }
        } else {
            RestLogicalErrorException authResponseErr = new RestLogicalErrorException("No restaurants for the given parameters");
            throw authResponseErr;
        }
        return commentModelList;
    }
    
    public boolean deleteComment(CommentModel commentModel) throws RestLogicalErrorException {
        
        if (commentModel.getCommentId()== null) {
            throw new RestLogicalErrorException("Parameters(ID) for deleting comment are incomplete.");
        }
        Comments comment = commentDao.getCommentById(commentModel.getReviewId());
        
        if (comment == null) {
            throw new RestLogicalErrorException("Delete operation unsuccessful. Invalid comment Id");
        }
        
        if (!commentDao.deleteComment(comment)) {
            throw new RestLogicalErrorException("Not able to delete comment");
        }
        return true;
    }
}

