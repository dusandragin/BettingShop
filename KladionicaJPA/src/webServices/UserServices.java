package webServices;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kladionica.data.UserData;
import kladionica.session.UserManager;

@Path("user")
public class UserServices {
	
	@Inject
	UserManager userBean;
	
	@Path("/register")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(UserData userData) throws Exception {
		Response res = userBean.insertUser(userData);
		return res;
	}
}
