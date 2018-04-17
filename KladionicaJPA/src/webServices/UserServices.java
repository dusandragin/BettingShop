package webServices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kladionica.data.UserData;
import kladionica.session.UserManager;

@Stateless
@Path("/") // URL path: 
public class UserServices {
	@EJB
	UserManager userBean;

	@Path("/login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginSubmit(UserData userData) throws Exception {
		Response res = userBean.findUser(userData);
		return res;
	}

}
