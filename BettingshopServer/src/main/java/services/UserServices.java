package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bettingshop.data.LoginParams;
import bettingshop.data.UserData;
import bettingshop.session.UserManager;

@Path("user")
public class UserServices {
	
	@Inject
	UserManager userBean;
	
	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(UserData userData) throws Exception {
		return userBean.insertUser(userData);
	}
	
	 @Path("/login")
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response loginSubmit(LoginParams userData) throws Exception {
		 return userBean.findUser(userData);
	 }
	 
	 
	 @Path("/tickets")
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response getTicketsForUser(LoginParams currUser) {
		 return userBean.getTicketsForUser(currUser);
	 }
}
