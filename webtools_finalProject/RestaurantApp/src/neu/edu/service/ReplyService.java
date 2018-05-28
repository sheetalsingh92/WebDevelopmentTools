/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.service;

import java.util.ArrayList;
import java.util.List;
import neu.edu.Comments;
import neu.edu.Replies;
import neu.edu.Reviews;
import neu.edu.User;
import neu.edu.dao.CommentDao;
import neu.edu.dao.ReplyDao;
import neu.edu.dao.ReviewDao;
import neu.edu.dao.UserDao;
import neu.edu.model.CommentModel;
import neu.edu.model.ReplyModel;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author shaurabh
 */
@Service
public class ReplyService {
    @Autowired
    UserDao userDao;
    
    @Autowired
    CommentDao commentDao;
    
    @Autowired
    ReplyDao replyDao;

    public boolean saveReply(ReplyModel replyModel, String username) throws RestLogicalErrorException{
        if (replyModel.getReplyDesc()== null || replyModel.getCommentId()== null) {
            throw new RestLogicalErrorException("Parameters for comment creation are incomplete.");
        }
        Replies reply = new Replies();
        User user = userDao.getUserByName(username);
        Comments comment = commentDao.getCommentById(replyModel.getCommentId());
        if (user == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. User not found with username: " + username);
        }
        if (comment == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. Comment not found with review ID: " + replyModel.getCommentId());
        }
        reply.setReplyDesc(replyModel.getReplyDesc());
        reply.setComments(comment);
        reply.setUser(user);

        if (!replyDao.saveReply(reply)) {
            throw new RestLogicalErrorException("Reply save operation failed. Reply already exist.");
        }
        return true;
    }
    
    public boolean deleteReply(ReplyModel replyModel) throws RestLogicalErrorException {
        
        if (replyModel.getReplyId()== null) {
            throw new RestLogicalErrorException("Parameters(ID) for reply review are incomplete.");
        }
        Replies reply = replyDao.getReplyById(replyModel.getReplyId());
        
        if (reply == null) {
            throw new RestLogicalErrorException("Delete operation unsuccessful. Invalid review Id");
        }
        
        if (!replyDao.deleteReply(reply)) {
            throw new RestLogicalErrorException("Not able to delete restaurant");
        }
        return true;
    }
}

