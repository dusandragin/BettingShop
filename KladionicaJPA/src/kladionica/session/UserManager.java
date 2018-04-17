package kladionica.session;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.util.JSON;

import kladionica.data.UserData;
import kladionica.entity.User;
import kladionica.session.local.UserManagerLocal;

@Stateless
@LocalBean
public class UserManager implements UserManagerLocal {
	@PersistenceContext(unitName = "KladionicaJPA")
	private EntityManager em;

	@Override
	public String insertUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatetUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCredit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserData getUserForUserName(String userName) {
		User user = (User) em.createQuery("select u from User u where u.username=:userName")
				.setParameter("userName", userName).getSingleResult();
		UserData userData = new UserData(user.getName(), user.getLastname(), user.getUsername(), user.getEmail(),
				user.getCredit());
		return userData;
	}

	public Response getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public Response findUser(UserData userData) {
		User user = (User) em.createQuery("select u from User u where u.username=:userName and u.password=:pass")
				.setParameter("userName", userData.getUsername()).setParameter("pass", userData.getPassword())
				.getSingleResult();
		Response response = null;
		UserData JSONRes = null;
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (user != null) {
			JSONRes = new UserData(user.getName(), user.getLastname(), user.getUsername(), user.getEmail(),
					user.getCredit());
			response = Response.ok(JSONRes, MediaType.APPLICATION_JSON).build();
			return response;
		}else {
			resMap.put("INFO", "Login is unsucessful!");
			String res = JSON.serialize(resMap);
			return Response.status(Response.Status.UNAUTHORIZED).entity(res).build();
		}
	}
	

}
