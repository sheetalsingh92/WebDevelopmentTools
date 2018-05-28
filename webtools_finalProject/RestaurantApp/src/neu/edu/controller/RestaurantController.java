package neu.edu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTML;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HeaderParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import neu.edu.model.CreateRestaurant;
import neu.edu.model.UserSession;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.RestaurantModel;
import neu.edu.model.RestaurantSearchModel;
import neu.edu.service.UserService;
import neu.edu.service.RestaurantService;

@Path("/restaurant")
@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GET
    @Path("/getRestaurantList")
    public Response getRestaurantList(@QueryParam("restaurantId") Integer restaurantId, @QueryParam("restaurantName") String restaurantName, @QueryParam("type") String type, @QueryParam("createdBy") String createdBy, @QueryParam("location") String location, @QueryParam("starRating") Integer starRating) {
        RestaurantSearchModel restaurantSearchModel = new RestaurantSearchModel();
        restaurantSearchModel.setCreatedByUserName(createdBy);
        restaurantSearchModel.setRestaurantId(restaurantId);
        restaurantSearchModel.setRestaurantName(restaurantName);
        restaurantSearchModel.setType(type);
        restaurantSearchModel.setLocation(location);
        restaurantSearchModel.setStarRating(starRating);
        try {
            List<RestaurantModel> list_of_restaurant = restaurantService.getRestaurantList(restaurantSearchModel);
            return Response.ok().entity(list_of_restaurant).build();

        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }

    }

    @POST
    @Path("/createRestaurant")
    public Response createRestaurant(RestaurantModel restaurant, @Context HttpServletRequest servletRequest) {
        UserSession userSession = null;
        try {
            UserService userService = new UserService();
            userSession = userService.getLoggedInUser(servletRequest);

            if (userSession == null) {
                System.out.println("User not found by auth-token in session");
            } else if (restaurantService.createRestaurant(restaurant, userSession.getUserName())) {
                return Response.ok().build();
            }
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(restaurant).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();

    }

    @POST
    @Path("/deleteRestaurant")
    public Response deleteRestaurant(String restaurant_name) {

        try {
            if (restaurantService.deleteRestaurant(restaurant_name)) {

                return Response.ok().build();
            }
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();

    }

    @POST
    @Path("/updateRestaurant")
    public Response updateRestaurant(RestaurantModel restaurant) {

        try {
            if (restaurantService.updateRestaurant(restaurant)) {
                return Response.ok().build();
            }
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(restaurant).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();

    }

}
