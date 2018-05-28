package neu.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import neu.edu.Owner;
import neu.edu.Restaurant;
import neu.edu.User;
import neu.edu.model.RestaurantSearchModel;
import neu.edu.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

@Service
public class RestaurantDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurantList(RestaurantSearchModel searchModel) {
        List<Restaurant> restaurantList = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();

            //https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
            //https://www.mkyong.com/hibernate/hibernate-criteria-examples/
            Criteria criteria = session.createCriteria(Restaurant.class);
            if (searchModel.getRestaurantId() != null) {
                criteria.add(Restrictions.eq("restaurantId", searchModel.getRestaurantId()));
            } else {
                if (searchModel.getRestaurantName() != null) {
                    criteria.add(Restrictions.like("restaurantName", searchModel.getRestaurantName()));
                }
                if (searchModel.getType() != null) {
                    criteria.add(Restrictions.eq("type", searchModel.getType()));
                }
                if (searchModel.getCreatedByUser() != null) {
                    criteria.add(Restrictions.eq("userByCreatedby", searchModel.getCreatedByUser()));
                }
                if (searchModel.getLocation() != null) {
                    criteria.add(Restrictions.eq("location", searchModel.getLocation()));
                }
                if (searchModel.getStarRating() != null) {
                    criteria.add(Restrictions.eq("starRating", searchModel.getStarRating()));
                }
            }
            restaurantList = (ArrayList<Restaurant>) criteria.list();
            session.flush();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return restaurantList;
    }

    public Restaurant getRestaurantById(Integer Id) {
        RestaurantSearchModel searchModel = new RestaurantSearchModel();
        searchModel.setRestaurantId(Id);
        return getRestaurantList(searchModel).get(0);
    }

    public Restaurant getRestaurantByName(String restaurant_name) {
        Restaurant restaurant = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();

            //https://www.tutorialspoint.com/hibernate/hibernate_criteria_queries.htm
            //https://www.mkyong.com/hibernate/hibernate-criteria-examples/
            Criteria criteria = session.createCriteria(Restaurant.class);
            if (restaurant_name != null) {
                criteria.add(Restrictions.eq("restaurantName", restaurant_name));
            }
            restaurant = (Restaurant) criteria.list().get(0);
            session.flush();
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
        } finally {
            session.close();
        }
        return restaurant;
    }

    public boolean deleteRestaurant(Restaurant restaurant) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.delete(restaurant);
            session.flush();
            return true;
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            System.out.println("Unsuccessful in deleting restaurant: " + restaurant.getRestaurantName());
        } finally {
            session.close();
        }
        return false;
    }

    public boolean createRestaurant(Restaurant restaurant) {
        Transaction tx = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

//            Query qr = session.createSQLQuery("INSERT INTO restaurant (restaurant_name, location, star_rating, Type, createdby)\n"
//                    + "VALUES (:r_name, :location, :rating, :type, :u_name)");
//            qr.setParameter("r_name", restaurant.getRestaurantName());
//            qr.setParameter("location", restaurant.getLocation());
//            qr.setParameter("rating", restaurant.getStarRating());
//            qr.setParameter("type", restaurant.getType());
//            qr.setParameter("u_name", user.getUsername());
            session.save(restaurant);
//            qr.executeUpdate();
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
        // TODO Auto-generated method stub
        return false;
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        Transaction tx = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(restaurant);
            tx.commit();
            return true;

        } catch (Exception ex) {
            System.out.println(ex);
            try {
                tx.rollback();
            } catch (Exception e) {
            }
        }
        // TODO Auto-generated method stub
        return false;
    }

}
