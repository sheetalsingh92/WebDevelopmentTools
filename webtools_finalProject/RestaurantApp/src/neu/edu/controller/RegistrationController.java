package neu.edu.controller;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import neu.edu.model.RegisterModel;
import neu.edu.model.RestLogicalErrorException;
import neu.edu.service.RegistrationService;

/**
 * Servlet implementation class RegistrationController
 */
@Path("/registration")
@Controller
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@POST
	@Path("/registeruser")
	public Response getRegisterUser(RegisterModel registerUser) {

		try {
			if (registrationService.getRegisterUser(registerUser)) {
				return Response.ok().build();
			}
		} catch (RestLogicalErrorException re) {
			return Response.ok().status(422).entity(re.getResponseError()).build();
		}

		return Response.ok().status(422).entity(new RestLogicalErrorException("Unknown Error. Please try again"))
				.build();

	}

//	@GET
//
//	public Response RegisterUser(@QueryParam("userID") int userID,
//								@QueryParam("userName") String userName){
//		System.out.println("sadfasd" + userID + userName);
//		
//		RestLogicalErrorException restLogicalErrorException = 	new RestLogicalErrorException("Unknown Error. Please try again");
//		
//			return Response.ok().status(422).entity(restLogicalErrorException.getResponseError()).build();
//			
//	}
}
