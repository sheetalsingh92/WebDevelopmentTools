/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.dao;

import java.util.ArrayList;
import java.util.List;
import neu.edu.Comments;
import neu.edu.Replies;
import neu.edu.Restaurant;
import neu.edu.Reviews;
import neu.edu.User;
import neu.edu.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author shaurabh
 */
public class ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Reviews> getReviewList(Integer reviewId, Restaurant restaurant, String restaurantName, Integer starRating) {
        List<Reviews> reviewList = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();

            //https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
            //https://www.mkyong.com/hibernate/hibernate-criteria-examples/
            Criteria criteria = session.createCriteria(Reviews.class);
            if (reviewId != null) {
                criteria.add(Restrictions.eq("reviewId", reviewId));
            } else {
                if (restaurant != null) {
                    criteria.add(Restrictions.eq("restaurant", restaurant));
                }
                if (restaurantName != null) {
                    criteria.add(Restrictions.like("restaurantName", restaurantName));
                }
                if (starRating != null) {
                    criteria.add(Restrictions.eq("starRating", starRating));
                }
            }
            reviewList = (ArrayList<Reviews>) criteria.list();
            for (Reviews review : reviewList) {
                // fetch all comments for the review
                Hibernate.initialize(review.getCommentses());
                for (Comments comment : review.getCommentses()) {
                    // fetch user and replies for all comments
                    Hibernate.initialize(comment.getUser());
                    Hibernate.initialize(comment.getReplieses());
                    for (Replies reply : comment.getReplieses()) {
                        //fetch user for each reply
                        Hibernate.initialize(reply.getUser());
                    }
                }
            }
            session.flush();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return reviewList;
    }

    public boolean saveReview(Reviews review) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(review);
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

    public Reviews getReviewById(Integer Id) {
        return getReviewList(Id, null, null, null).get(0);
    }

    public boolean deleteReview(Reviews review) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.delete(review);
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
