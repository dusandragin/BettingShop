package kladionica.session;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import kladionica.data.LoginParams;
import kladionica.data.UserData;
import kladionica.entity.User;

@Stateless
public class UserManager {
	
	@PersistenceContext(unitName = "KladionicaJPA")
	private EntityManager em;

	public Response insertUser(UserData ud) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		UserData JSONRes = null;
		try {
			System.out.println("11111");
			System.out.println("22222");
			User newUser = new User(ud.getName(), ud.getLastname(), ud.getUsername(), ud.getEmail(), ud.getPassword(), 0.0, "user");
			System.out.println("333333");
			em.persist(newUser);
			System.out.println("444444");
			JSONRes = new UserData(newUser.getCredit(), newUser.getEmail(), newUser.getName(), newUser.getLastname(), newUser.getUsername());
			return Response.ok(JSONRes, MediaType.APPLICATION_JSON)
					   .build();
		} catch (Exception e) {
			e.printStackTrace();
			resMap.put("info", "Registration unsucessfull. Please try again.");
			return Response.ok("nije ok").build() ;
		}
	}
	// looking only for username and password
	public Response findUser(LoginParams userData) {
		User newUser = (User) em
				.createQuery("select u from User u " + "where u.email=:email " + "and u.password=:pass")
				.setParameter("email", userData.getEmail())
				.setParameter("pass", userData.getPassword())
				.getSingleResult();
		UserData JSONRes = null;
		if (newUser != null) {
			JSONRes = new UserData(newUser.getCredit(), newUser.getEmail(), newUser.getName(), newUser.getLastname(), newUser.getUsername());
			return Response.ok(JSONRes, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.ok("login fail").build();
		}
	}
	
}
