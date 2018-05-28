package neu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import neu.edu.Comments;
import neu.edu.Restaurant;
import neu.edu.Reviews;
import neu.edu.User;
import neu.edu.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Comments> getCommentList(Integer commentId, Reviews review) {
        List<Comments> commentList = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();

            //https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
            //https://www.mkyong.com/hibernate/hibernate-criteria-examples/
            Criteria criteria = session.createCriteria(Comments.class);
            if (commentId != null) {
                criteria.add(Restrictions.eq("commentId", commentId));
            } else if (review != null) {
                criteria.add(Restrictions.eq("reviews", review));
            } 
            commentList = (ArrayList<Comments>) criteria.list();
            session.flush();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return commentList;
    }

    public boolean saveComment(Comments comment) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(comment);
            tx.commit();
            session.flush();
            return true;
        } catch (Exception ex) {
            System.out.println(ex);
            try {
                tx.rollback();
            } catch (Exception e) {
            }

        } finally {
            session.close();
        }
        return false;
    }

    public Comments getCommentById(Integer Id) {
        return (Comments)getCommentList(Id, null).get(0);
    }
    
    public boolean deleteComment(Comments comment) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.delete(comment);
            session.flush();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return false;
    }
}
