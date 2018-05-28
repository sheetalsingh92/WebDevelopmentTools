package neu.edu.dao;

import neu.edu.Replies;
import neu.edu.Reviews;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean saveReply(Replies reply) {
        Transaction tx = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(reply);
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
    
    public boolean deleteReply(Replies reply) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.delete(reply);
            session.flush();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return false;
    }

    public Replies getReplyById(Integer replyId) {
        Replies reply = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            reply = (Replies)session.load(Replies.class,replyId);
            session.flush();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return reply;
    }
}
