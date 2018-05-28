package neu.edu.model;

import java.util.HashSet;
import java.util.Set;
import neu.edu.Comments;
import neu.edu.Customer;
import neu.edu.Restaurant;

public class ReviewModel {

    public ReviewModel(){}
    
    public ReviewModel(Integer reviewId, Integer restaurantId, String comment, Integer starRating, Integer serviceRating, Integer foodRating, Integer cost) {
        this.reviewId = reviewId;
        this.restaurantId = restaurantId;
        this.comment = comment;
        this.starRating = starRating;
        this.serviceRating = serviceRating;
        this.foodRating = foodRating;
        this.cost = cost;
    }

    private Integer reviewId;
    private Integer restaurantId ;
    private String comment;
    private Integer starRating;
    private Integer serviceRating;
    private Integer foodRating;
    private Integer cost;
    private Set<CommentModel> comments = new HashSet<>(0);

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<CommentModel> getComments() {
        return comments;
    }

    public void setComments(Set<CommentModel> comments) {
        this.comments = comments;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Integer getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Integer serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Integer getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Integer foodRating) {
        this.foodRating = foodRating;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

}
