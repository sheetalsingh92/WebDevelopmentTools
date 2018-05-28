package neu.edu.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import neu.edu.model.AuthRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;

import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.UserSession;
import neu.edu.service.UserService;

@Path("/user")
@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Autowired
    private UserService userService;
    @POST
    @Path("/deleteUser")
    public Response deleteUser(String Username) {
        try {
            userService.deleteUser(Username);
            return Response.ok().build();

        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }

    }

}
