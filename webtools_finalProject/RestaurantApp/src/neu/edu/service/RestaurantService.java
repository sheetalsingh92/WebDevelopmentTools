package neu.edu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.Restaurant;
import neu.edu.User;
import neu.edu.dao.RestaurantDao;
import neu.edu.dao.UserDao;
import neu.edu.model.CreateRestaurant;
import neu.edu.model.UserSession;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.RestaurantModel;
import neu.edu.model.RestaurantSearchModel;

@Service
public class RestaurantService {

    @Autowired
    public RestaurantDao restaurantDao;

    @Autowired
    public UserDao userDao;

    public List<RestaurantModel> getRestaurantList(RestaurantSearchModel searchModel) throws RestLogicalErrorException {
        User createdByUser = null;
        if(searchModel.getCreatedByUserName() != null){
            searchModel.setCreatedByUser(userDao.getUserByName(searchModel.getCreatedByUserName()));
            if(createdByUser == null){
                System.out.println("for createdBy, user not found");
            }
        }
        List<Restaurant> restaurantList = restaurantDao.getRestaurantList(searchModel);
        List<RestaurantModel> restaurantListModel = new ArrayList<>();

        if (!restaurantList.isEmpty()) {
            for (Restaurant restaurant : restaurantList) {
                restaurantListModel.add(new RestaurantModel(
                        restaurant.getRestaurantName(),
                        restaurant.getLocation(),
                        restaurant.getStarRating(),
                        restaurant.getType(),
                        restaurant.getApprovalStatus()
                ));
            }
        } else {
            RestLogicalErrorException authResponseErr = new RestLogicalErrorException("No restaurants for the given parameters");
            throw authResponseErr;
        }
        return restaurantListModel;
    }

    public RestaurantModel getRestaurantByName(String restaurant_name) throws RestLogicalErrorException {

        if (restaurant_name == null) {
            throw new RestLogicalErrorException("Get restaurant operation failed. Restaurant name is empty");
        }
        Restaurant restaurant = restaurantDao.getRestaurantByName(restaurant_name);
        RestaurantModel restaurantModel = null;

        if (restaurant == null) {
            RestLogicalErrorException authResponseErr = new RestLogicalErrorException("Get restaurant operation failed. Invalid restaurant name");
            throw authResponseErr;
        } else {
            restaurantModel = new RestaurantModel(
                    restaurant.getRestaurantName(),
                    restaurant.getLocation(),
                    restaurant.getStarRating(),
                    restaurant.getType(),
                    restaurant.getApprovalStatus()
            );
        }
        return restaurantModel;
    }

    
    public boolean createRestaurant(RestaurantModel restaurantModel, String username) throws RestLogicalErrorException {
        if (restaurantModel.getRestaurantName() == null || restaurantModel.getLocation() == null || restaurantModel.getStar_rating() == 0 || restaurantModel.getType() == null) {
            throw new RestLogicalErrorException("Parameters for restaurant creation are incomplete.");
        }
        Restaurant restaurant = new Restaurant();
        User user = userDao.getUserByName(username);
        if (user == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. User not found with username: " + username);
        }
        restaurant.setRestaurantName(restaurantModel.getRestaurantName());
        restaurant.setLocation(restaurantModel.getLocation());
        restaurant.setStarRating(restaurantModel.getStar_rating());
        restaurant.setType(restaurantModel.getType());
        restaurant.setUser(user);

        if (!restaurantDao.createRestaurant(restaurant)) {
            throw new RestLogicalErrorException("Create restaurant operation failed. Retaurant already exist.");
        }
        return true;
    }

    public boolean deleteRestaurant(String restaurant_name) throws RestLogicalErrorException {
        
        if (restaurant_name == null) {
            throw new RestLogicalErrorException("Parameters for restaurant creation are incomplete.");
        }
        Restaurant restaurant = restaurantDao.getRestaurantByName(restaurant_name);
        
        if (restaurant == null) {
            throw new RestLogicalErrorException("Delete operation unsuccessful. Invalid restaurant name");
        }
        
        if (!restaurantDao.deleteRestaurant(restaurant)) {
            throw new RestLogicalErrorException("Not able to delete restaurant");
        }
        return true;
    }

    public boolean updateRestaurant(RestaurantModel restaurantModel) throws RestLogicalErrorException {
        if (restaurantModel.getRestaurantName() == null || restaurantModel.getLocation() == null || restaurantModel.getStar_rating() == 0 || restaurantModel.getType() == null) {
            throw new RestLogicalErrorException("Parameters for restaurant creation are incomplete.");
        }
        Restaurant restaurant = restaurantDao.getRestaurantByName(restaurantModel.getRestaurantName());

        if (restaurant == null) {
            RestLogicalErrorException authResponseErr = new RestLogicalErrorException("Update operation unsuccessful. Invalid restaurant name");
            throw authResponseErr;
        }
        restaurant.setLocation(restaurantModel.getLocation());
        restaurant.setStarRating(restaurantModel.getStar_rating());
        restaurant.setType(restaurantModel.getType());

        //todo: approval status update can only be done by admin
        restaurant.setApprovalStatus(restaurantModel.getApproval_status());

        if (!restaurantDao.updateRestaurant(restaurant)) {
            throw new RestLogicalErrorException("Not able to update restaurant");
        }
        return true;
    }

}
