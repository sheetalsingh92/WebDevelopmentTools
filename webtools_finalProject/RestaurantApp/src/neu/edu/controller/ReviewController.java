package neu.edu.controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.ReviewModel;
import neu.edu.model.UserSession;
import neu.edu.service.ReviewService;
import neu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("/review")
@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @POST
    @Path("/saveReview")
    public Response saveReview(ReviewModel reviewModel, @Context HttpServletRequest servletRequest) {
        try {
            UserService userService = new UserService();
            UserSession userSession = userService.getLoggedInUser(servletRequest);
            if (userSession == null) {
                System.out.println("User not found by auth-token in session");
            } else if (reviewService.saveReview(reviewModel, userSession.getUserName())) {
                return Response.ok().build();
            }

        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();

    }
    
    @GET
    @Path("/getReviewList")
    public Response getReviewList(@QueryParam("restaurantID") Integer restaurantID) {
        try {
            List<ReviewModel> reviewList = reviewService.getReviewList(restaurantID);
            return Response.ok().entity(reviewList).build();
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }
    }
    
    @POST
    @Path("/deleteReview")
    public Response deleteReview(ReviewModel reviewModel){
        try {
            if (reviewService.deleteReview(reviewModel)) {
                return Response.ok().build();
            }
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();
    }
}
