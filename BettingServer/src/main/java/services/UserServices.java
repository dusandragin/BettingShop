package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bettingshop.data.LoginParams;
import bettingshop.data.TicketData;
import bettingshop.data.UserData;
import bettingshop.entity.Ticket;
import bettingshop.session.UserManager;

@Path("user")
public class UserServices {

	@Inject
	private UserManager userBean;

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

	@Path("/payTicket")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTicket(TicketData body) {
		return userBean.addTicket(body);
	}

	@Path("/isTicketValid")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response isTicketValid(Ticket body) {
		return userBean.isTicketValid(body);
	}

	@Path("/getAllGamesForDate/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGamesForDate(@PathParam(value = "date") String date) {
		return userBean.getAllGamesForDate(date);
	}
	
	@Path("/credit")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGamesForDate(LoginParams params) {
		return userBean.getCurrUserCredit(params);
	}
	
	@Path("/addCredit")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCredit(UserData body) {
		return userBean.addCreditForCurrentUser(body);
	}

}
