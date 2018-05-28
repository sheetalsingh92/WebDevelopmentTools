/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neu.edu.controller;

import java.util.List;
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

import neu.edu.model.CommentModel;
import neu.edu.model.ReplyModel;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.model.ReviewModel;
import neu.edu.model.UserSession;
import neu.edu.service.CommentService;
import neu.edu.service.ReplyService;
import neu.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Path("/reply")
@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class replyController {
    @Autowired
    ReplyService replyService;

    @POST
    @Path("/saveReply")
    public Response saveReply(ReplyModel replyModel, @Context HttpServletRequest servletRequest) {
        try {
            UserService userService = new UserService();
            UserSession userSession = userService.getLoggedInUser(servletRequest);
            if (userSession == null) {
                System.out.println("User not found by auth-token in session");
            } else if (replyService.saveReply(replyModel, userSession.getUserName())) {
                return Response.ok().build();
            }

        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).entity(re.getResponseError()).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();
    }
    
    @POST
    @Path("/deleteReply")
    public Response deleteReply(ReplyModel replyModel){
        try {
            if (replyService.deleteReply(replyModel)) {
                return Response.ok().build();
            }
        } catch (RestLogicalErrorException re) {
            return Response.ok().status(422).build();
        }

        return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
                .build();
    }
}
