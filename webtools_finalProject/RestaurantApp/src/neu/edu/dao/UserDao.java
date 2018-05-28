package neu.edu.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.Admin;
import neu.edu.Customer;
import neu.edu.Owner;
import neu.edu.User;
import neu.edu.util.HibernateUtil;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserByName(String username) {
        Session session = null;
        User user = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from User where username = :un");
            query.setParameter("un", username);
            user = (User) query.list().get(0);
            session.flush();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            session.close();
        }
        return user;
    }

    public User getUserByName(String username, Session session) throws Exception {
        User user = null;
        Query query = session.createQuery("from User where username = :un");
        query.setParameter("un", username);
        user = (User) query.list().get(0);
        session.flush();
        return user;
    }
    
    public Customer getCustomerByName(String username){
        Session session = null;
        Customer customer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria customerCriteria = session.createCriteria(Customer.class);
            Criteria userCriteria = customerCriteria.createCriteria("user");
            userCriteria.add(Restrictions.eq("username", username));
            customer = (Customer) customerCriteria.list().get(0);
            session.flush();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            session.close();
        }
        return customer;
    }

    public boolean userRegistration(User user) {
        Transaction tx = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(user);
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

    public User validateUser(String username, String password) {
        User user = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from User where username=:un and password=:pass ");
            query.setString("un", username);
            query.setString("pass", password);
            user = (User) query.list().get(0);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.flush();
            session.close();
        }
        return user;
    }

    public boolean deleteUser(User user) {
        Session session = null;
        if (user.getType().equals("admin")) {
            return false;
        }
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.delete(user);
            session.flush();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            System.out.println("Unsuccessful in deleting restaurant: " + user.getUsername());
        } finally {
            session.close();
        }
        return false;
    }
}
