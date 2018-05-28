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
import bettingshop.entity.Category;
import bettingshop.entity.Game;
import bettingshop.entity.League;
import bettingshop.entity.Result;
import bettingshop.entity.Ticket;
import bettingshop.entity.User;

@Stateless
public class UserManager {

	@PersistenceContext(unitName = "BettingServer")
	private EntityManager em;

	public Response insertUser(UserData ud) {
		try {
			User newUser = new User(ud.getName(), ud.getLastname(), ud.getUsername(), ud.getEmail(), ud.getPassword(),
					0.0f, "user");
			em.persist(newUser);
			UserData JSONRes = new UserData(newUser.getCredit(), newUser.getEmail(), newUser.getName(),
					newUser.getLastname(), newUser.getUsername());
			return Response.ok(JSONRes, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			String jsonRes = JSON.serialize("Registration unsucessfull. Please try again.");
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(jsonRes).build();
		}
	}

	public Response findUser(LoginParams userData) {
		try {
			User user = em
					.createQuery("select u from User u " + "where u.email=:email " + "and u.password=:pass", User.class)
					.setParameter("email", userData.getEmail()).setParameter("pass", userData.getPassword())
					.getSingleResult();
			return Response.ok(user, MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			e.printStackTrace();
			String jsonRes = JSON.serialize("Login fail. No entity for: " + userData.getEmail());
			return Response.status(Response.Status.NOT_FOUND).entity(jsonRes).build();
		}
	}

	public Response getTicketsForUser(LoginParams currUserParams) {
		User currUser = em
				.createQuery("select u from User u " + "where u.email=:email " + "and u.password=:pass", User.class)
				.setParameter("email", currUserParams.getEmail()).setParameter("pass", currUserParams.getPassword())
				.getSingleResult();
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = em.createQuery("select t from Ticket t where t.user =:currUser")
				.setParameter("currUser", currUser).getResultList();
		// DataBean is required - Result is mapped with @JsonIgnore
		List<UserTickets> userTickets = new ArrayList<>();
		for (Ticket ticket : tickets) {
			UserTickets ut = new UserTickets();
			ut.setIdTicket(ticket.getIdTicket());
			ut.setPotentionalWinnings(ticket.getPotentionalWinnings());
			ut.setStake(ticket.getStake());
			ut.setTime(ticket.getTime());
			ut.setTotalOdd(ticket.getTotalOdd());
			ut.setValid(ticket.getValid());
			@SuppressWarnings("unchecked")
			List<Result> results = em.createQuery("select r from Result r where r.ticket=:ticket")
					.setParameter("ticket", ticket).getResultList();
			ut.setResults(results);
			userTickets.add(ut);
		}
		return Response.ok().entity(userTickets).build();
	}

	public Response addTicket(TicketData body) {
		System.out.println("== usao add ticket ==");
		String jsonRes;
		try {
			System.out.println("== credit: " + body.getUser().getCredit());
			if (body.getUser() != null) {
				User user = em.find(User.class, body.getUser().getIdUser());
				if (user.getCredit() >= body.getSum()) {
					System.out.println("== sum ==" + body.getSum());
					List<GameData> gamesData = body.getGames();
					System.out.println("== gamesData size:  " + gamesData.size());
					double odd = 1;
					Ticket ticket = new Ticket();
					ticket.setStake(body.getSum());
					ticket.setUser(user);
					ticket.setTime(Calendar.getInstance().getTime());
					em.persist(ticket);
					boolean validTicket = true;
					for (GameData gd : gamesData) {
						Game game = em.find(Game.class, gd.getIdMatch());
						Result res = new Result();
						res.setGame(game);
						res.setTicket(ticket);
						res.setResult(gd.getResult());
						if (ticket.getResults() == null || ticket.getResults().isEmpty()) {
							List<Result> newResults = new ArrayList<>();
							newResults.add(res);
							ticket.setResults(newResults);
						} else {
							ticket.addResult(res);
						}
						odd *= gd.getOdd();
						ticket.setPotentionalWinnings(odd * body.getSum());
						if (compareResults(game.getHomeScore(), game.getAwayScore()) == 0) {
							if (res.getResult() != 0)
								validTicket = false;
						} else if (compareResults(game.getHomeScore(), game.getAwayScore()) > 0) {
							if (res.getResult() != 1)
								validTicket = false;
						} else {
							if (res.getResult() != 2)
								validTicket = false;
						}
						em.persist(res);
					}
					ticket.setTotalOdd(odd);
					user.setCredit(user.getCredit() - body.getSum()); // set new credit for user
					ticket.setValid(validTicket);
					em.merge(user);
					em.merge(ticket);
					return Response.ok(user, MediaType.APPLICATION_JSON).build();
				} else {
					jsonRes = JSON.serialize("Uplata neuspesna. Nemate dovoljno novca.");
				}
			} else {
				jsonRes = JSON.serialize("Uplata neuspesna. Niste dodali nijedan tiket.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonRes = JSON.serialize("Uplata neuspesna. ");
		}
		return Response.ok().entity(jsonRes).build();
	}

	private int compareResults(int home, int away) {
		return home - away;
	}

	public Response isTicketValid(Ticket body) {
		Calendar cal = Calendar.getInstance();
		List<Result> results = body.getResults();
		for (Result r : results) {
			Game tmpG = r.getGame();
			Integer fullTime = 90 * 60 * 1000 + 15 * 60 * 1000;
			if (tmpG.getTime().getTime() + fullTime > cal.getTimeInMillis()) {
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
		List<Game> games = new ArrayList<Game>();// null;
		games = em.createQuery("select g from Game g", Game.class)// g where g.time=:time order by g.league
				// .setParameter("time", date)
				.getResultList();
		// if (games!=null) {
		// String jsonRes = JSON.serialize("Nema utakmica za odabrani datum." );
		// return Response.ok().entity(jsonRes).build();
		// } else {
		// return Response.ok(games, MediaType.APPLICATION_JSON).build();
		// }
		GamesData gd = new GamesData();
		gd.setGames(games);
		return Response.ok(gd, MediaType.APPLICATION_JSON).build();
	}

	public Response getCurrUserCredit(LoginParams currUserParams) {
		User currUser = em
				.createQuery("select u from User u " + "where u.email=:email " + "and u.password=:pass", User.class)
				.setParameter("email", currUserParams.getEmail()).setParameter("pass", currUserParams.getPassword())
				.getSingleResult();
		return Response.ok(currUser).build();
	}

	public Response addCreditForCurrentUser(UserData body) {
		User currUser = em
				.createQuery("select u from User u " + "where u.email=:email " + "and u.password=:pass", User.class)
				.setParameter("email", body.getEmail()).setParameter("pass", body.getPassword()).getSingleResult();
		double newCredit = currUser.getCredit() + body.getCredit();
		currUser.setCredit(newCredit);
		em.merge(currUser);
		body.setCredit(currUser.getCredit());
		return Response.ok(body).build();
	}

	public Response getAllCategories() {
		@SuppressWarnings("unchecked")
		List<Category> categories = em.createNamedQuery("Category.findAll").getResultList();
		return Response.ok(categories).build();
	}

	@SuppressWarnings("unchecked")
	public Response getGamesForCategory(String category) {
		List<Game> games = new ArrayList<Game>();
		if (category.equalsIgnoreCase("all")) {
			games = em.createNamedQuery("Game.findAll").getResultList();
		} else {
			games = em.createQuery("select g from Game g where g.league.category.name =:cat")
					.setParameter("cat", category).getResultList();
		}
		GamesData gd = new GamesData();
		gd.setGames(games);
		return Response.ok(gd).build();
	}

	@SuppressWarnings("unchecked")
	public Response getLeaguesForCategory(String category) {
		List<League> leagues = new ArrayList<>();
		if (category.equalsIgnoreCase("all")) {
			leagues = em.createNamedQuery("League.findAll").getResultList();
		} else {
			leagues = em.createQuery("select l from League l where l.category.name =:cat").setParameter("cat", category)
					.getResultList();
		}
		return Response.ok(leagues).build();
	}

	@SuppressWarnings("unchecked")
	public Response getGamesForLeague(String league) {
		List<Game> games = new ArrayList<>();
		games = em.createQuery("select g from Game g where g.league.name =:ln")
				.setParameter("ln", league)
				.getResultList();
		GamesData gd = new GamesData();
		gd.setGames(games);
		return Response.ok(gd).build();
	}

}
