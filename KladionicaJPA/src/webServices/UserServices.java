package webServices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kladionica.data.UserData;
import kladionica.session.UserManager;

@Stateless
@Path("user") // URL path: /bet/user
public class UserServices {
	@EJB
	UserManager userBean;

	// This is non secured method
	@Path("showMatches")
	@GET
	public void showAvailableMatches(@Context HttpServletRequest req, @Context HttpServletResponse res) {

	}

	// This is secured method
	// Test URL: http://localhost:8080/KladionicaWebClient/bet/user/betOnTicket
	@Path("betOnTicket")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void betOnTicket(@Context HttpServletRequest req, @Context HttpServletResponse res) throws Exception {
		System.out.println(" == get username: " + req.getRemoteUser());
		UserData userData = userBean.getUserForUserName(req.getRemoteUser());

		req.setAttribute("user", userData);
		req.getRequestDispatcher("/home.jsp").forward(req, res);
	}

	// http://localhost:8080/KladionicaWebClient/bet/user/login
	@Path("login")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void login(@Context HttpServletRequest req, @Context HttpServletResponse res) throws Exception {
		System.out.println(" == get username: " + req.getRemoteUser() + " usao");
//		UserData userData = userManager.getUserForUserName(req.getRemoteUser());

//		req.setAttribute("user", userData);
		req.getRequestDispatcher("/home.jsp").forward(req, res);
	}
	
	@Path("login")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response login() throws Exception {
		Response res = userBean.getUser();
		return res;
	}
	
	@Path("loginSubmit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginSubmit(UserData userData) throws Exception {
		Response res = userBean.findUser(userData);
		return res;
	}
}
