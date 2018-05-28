package neu.edu.service;

import java.util.ArrayList;
import java.util.List;
import neu.edu.Comments;
import neu.edu.Customer;
import neu.edu.Restaurant;
import neu.edu.Reviews;
import neu.edu.User;
import neu.edu.dao.CommentDao;
import neu.edu.dao.RestaurantDao;
import neu.edu.dao.ReviewDao;
import neu.edu.dao.UserDao;
import neu.edu.model.CommentModel;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.ReviewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestaurantDao restaurantDao;

    @Autowired
    private ReviewDao reviewDao;

    @Autowired
    private CommentDao commentDao;

    public boolean saveReview(ReviewModel reviewModel, String username) throws RestLogicalErrorException {
        if (reviewModel.getStarRating() == null || reviewModel.getFoodRating() == null || reviewModel.getServiceRating() == null) {
            throw new RestLogicalErrorException("Parameters for restaurant creation are incomplete.");
        }
        Reviews review = new Reviews();
        Customer customer = userDao.getCustomerByName(username);
        Restaurant restaurant = restaurantDao.getRestaurantById(reviewModel.getRestaurantId());
        if (customer == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. User not found with username: " + username);
        }
        if (restaurant == null) {
            throw new RestLogicalErrorException("Create restaurant operation failed. restaurant not found with restaurant ID: " + reviewModel.getRestaurantId());
        }
        review.setComments(reviewModel.getComment());
        review.setStarRating(reviewModel.getStarRating());
        review.setFoodRating(reviewModel.getFoodRating());
        review.setServiceRating(reviewModel.getServiceRating());
        review.setCost(reviewModel.getCost());
        review.setCustomer(customer);
        review.setRestaurant(restaurant);
//        customer.getReviewses().add(review);

        if (!reviewDao.saveReview(review)) {
            throw new RestLogicalErrorException("Create restaurant operation failed. Retaurant already exist.");
        }
        return true;
    }

    public List<ReviewModel> getReviewList(Integer restaurantId) throws RestLogicalErrorException {
        Restaurant restaurant = restaurantDao.getRestaurantById(restaurantId);
        List<Reviews> reviewList = reviewDao.getReviewList(null, restaurant, null, null);
        List<ReviewModel> reviewListModel = new ArrayList<>();

        if (!reviewList.isEmpty()) {
            for (Reviews review : reviewList) {
                ReviewModel reviewModel = new ReviewModel(
                        review.getReviewId(),
                        review.getRestaurant().getRestaurantId(),
                        review.getComments(),
                        review.getStarRating(),
                        review.getServiceRating(),
                        review.getFoodRating(),
                        review.getCost()
                );
                for (Comments comment : review.getCommentses()) {
                    reviewModel.getComments().add(new CommentModel(
                            comment.getCommentId(),
                            review.getReviewId(),
                            comment.getUser().getUsername(),
                            comment.getCommentDesc()
                    ));
                }
                reviewListModel.add(reviewModel);
            }
        } else {
            RestLogicalErrorException authResponseErr = new RestLogicalErrorException("No restaurants for the given parameters");
            throw authResponseErr;
        }
        return reviewListModel;
    }
    
    
    public boolean deleteReview(ReviewModel reviewModel) throws RestLogicalErrorException {
        
        if (reviewModel.getReviewId() == null) {
            throw new RestLogicalErrorException("Parameters(ID) for deleting review are incomplete.");
        }
        Reviews review = reviewDao.getReviewById(reviewModel.getReviewId());
        
        if (review == null) {
            throw new RestLogicalErrorException("Delete operation unsuccessful. Invalid review Id");
        }
        
        if (!reviewDao.deleteReview(review)) {
            throw new RestLogicalErrorException("Not able to delete review");
        }
        return true;
    }
}
