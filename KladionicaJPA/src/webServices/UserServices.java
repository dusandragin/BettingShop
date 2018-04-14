package webServices;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("user") // URL path: /bet/user
public class UserServices {
	//neki servisi
	
	// This is non secured method
	@Path("showMatches")
	@GET
	public void showAvailableMatches(@Context HttpServletRequest req, @Context HttpServletResponse res ) {
		
	}
	
	// This is secured method 
	// Test URL: http://localhost:8080/KladionicaWebClient/bet/user/betOnTicket
	@Path("betOnTicket")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String betOnTicket(@Context HttpServletRequest req, @Context HttpServletResponse res) {
		System.out.println(" == get username: " + req.getRemoteUser());
		return "It works";
	}
	
}
