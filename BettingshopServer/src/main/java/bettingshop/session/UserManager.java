package bettingshop.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.util.JSON;

import bettingshop.data.LoginParams;
import bettingshop.data.UserData;
import bettingshop.data.UserTickets;
import bettingshop.entity.Ticket;
import bettingshop.entity.User;


@Stateless
public class UserManager {
	
	@PersistenceContext(unitName = "KladionicaServer")
	private EntityManager em;

	public Response insertUser(UserData ud) {
		try {
			User newUser = new User(ud.getName(), ud.getLastname(), 
								    ud.getUsername(), ud.getEmail(), 
								    ud.getPassword(), 0.0, "user");
			em.persist(newUser);
			UserData JSONRes = new UserData(newUser.getCredit(), newUser.getEmail(), 
								   newUser.getName(), newUser.getLastname(), 
								   newUser.getUsername());
			return Response.ok(JSONRes, MediaType.APPLICATION_JSON)
					   .build();
		} catch (Exception e) {
			e.printStackTrace();
			String jsonRes = JSON.serialize("Registration unsucessfull. Please try again.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						   .entity(jsonRes)
						   .build();
		}
	}
	
	// Looking for user-name and password
	public Response findUser(LoginParams userData) {
		try {
			User user =  em.createQuery("select u from User u " + 
										"where u.email=:email " + 
										"and u.password=:pass", User.class)
							.setParameter("email", userData.getEmail())
							.setParameter("pass", userData.getPassword())
							.getSingleResult();
//			UserData JSONRes = new UserData(user.getCredit(), user.getEmail(), 
//								   user.getName(), user.getLastname(), 
//								   user.getUsername());
			return Response.ok(user, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			String jsonRes = JSON.serialize("Login fail. No entity for: " + userData.getEmail());
			return Response.status(Response.Status.NOT_FOUND)
						   .entity(jsonRes)
						   .build();
		}
	}
	
	public Response getTicketsForUser(LoginParams currUserParams) {
		User currUser = em.createQuery("select u from User u " + 
				   					   "where u.email=:email " + 
				   					   "and u.password=:pass", User.class)
						  .setParameter("email", currUserParams.getEmail())
						  .setParameter("pass", currUserParams.getPassword())
						  .getSingleResult();
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = em.createQuery("select t from Ticket t where t.user =:currUser")
								 .setParameter("currUser", currUser)
								 .getResultList();
		UserTickets userTickets = new UserTickets();
		userTickets.setTickets(tickets);
		return Response.ok().entity(userTickets).build();
	}
	
}
