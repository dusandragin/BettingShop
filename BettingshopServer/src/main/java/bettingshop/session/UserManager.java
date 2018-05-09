package bettingshop.session;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.util.JSON;

import bettingshop.data.GameData;
import bettingshop.data.GamesData;
import bettingshop.data.LoginParams;
import bettingshop.data.TicketData;
import bettingshop.data.UserData;
import bettingshop.data.UserTickets;
import bettingshop.entity.Game;
import bettingshop.entity.Result;
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

	public Response addTicket(TicketData body) {
		System.out.println("AAAAAAAA");
		String jsonRes;
		try {
			if(body.getUser()!=null) {
				User user = em.find(User.class, body.getUser().getIdUser());
				if (user.getCredit() >= body.getSum()) {
					List<GameData> gamesData = body.getGames();
					List<Result>results = new ArrayList<Result>();
					double odd = 1;
					System.out.println("DADSAv "+gamesData.size());
					for (GameData gd : gamesData) {
						Game game = em.find(Game.class, gd.getIdMatch());
						Result res = new Result();
						res.setGame(game);
						res.setResult(gd.getResult());
						results.add(res);
						System.out.println("Odd = " + gd.getOdd());
						odd *= gd.getOdd();
					}
					Ticket ticket = new Ticket();
					ticket.setResults(results);
					ticket.setStake(body.getSum());
					ticket.setUser(user);
					ticket.setPotentionalWinnings(odd*body.getSum());
					ticket.setTotalOdd(odd);
					ticket.setTime(Calendar.getInstance().getTime());
					em.persist(ticket);
					return Response.ok(body, MediaType.APPLICATION_JSON).build();
				} else {
					jsonRes = JSON.serialize("Uplata neuspesna. Nemate dovoljno novca." );				
				}
			} else {
				jsonRes = JSON.serialize("Uplata neuspesna. Niste dodali nijedan tiket." );
			}
		} catch (Exception e) {
			jsonRes = JSON.serialize("Uplata neuspesna. " );	
		}
		return Response.ok().entity(jsonRes).build();
	}
	
	public Response isTicketValid(Ticket body) {
		Calendar cal = Calendar.getInstance();
		List<Result>results = body.getResults();
		for (Result r : results) {
			Game tmpG = r.getGame();
			Integer fullTime = 90*60*1000 + 15*60*1000;
			if (tmpG.getTime().getTime()+fullTime > cal.getTimeInMillis()) { 
				return Response.ok(body, MediaType.APPLICATION_JSON).build();
			} else {
				if (tmpG.getAwayScore() == tmpG.getHomeScore()) {
					if (r.getResult() != 0) {
						body.setValid(false);
						em.merge(body);
						return Response.ok(body, MediaType.APPLICATION_JSON).build();
					}
				} else if (tmpG.getAwayScore() > tmpG.getHomeScore()) {
					if (r.getResult() != 2) {
						body.setValid(false);
						em.merge(body);
						return Response.ok(body, MediaType.APPLICATION_JSON).build();
					}
				} else if (tmpG.getAwayScore() < tmpG.getHomeScore()) {
					if (r.getResult() != 1) {
						body.setValid(false);
						em.merge(body);
						return Response.ok(body, MediaType.APPLICATION_JSON).build();
					}
				} 
				
			} 
		}
		body.setValid(true);
		em.merge(body);
		return Response.ok(body, MediaType.APPLICATION_JSON).build();
	}
	public Response getAllGamesForDate(String date) {
		System.out.println("date "+date);
		List<Game>games = new ArrayList<Game>();//null;
		games = em.createQuery("select g from Game g", Game.class)//g where g.time=:time order by g.league
			//	.setParameter("time", date)
				.getResultList();
//		if (games!=null) {
//			String jsonRes = JSON.serialize("Nema utakmica za odabrani datum." );
//			return Response.ok().entity(jsonRes).build();
//		} else {
//			return Response.ok(games, MediaType.APPLICATION_JSON).build();
//		}
		GamesData gd = new GamesData();
		gd.setGames(games);
		return Response.ok(gd, MediaType.APPLICATION_JSON).build();
	}
}
