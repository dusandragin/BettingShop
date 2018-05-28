package bettingshop.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import bettingshop.data.GamesData;
import bettingshop.entity.Category;
import bettingshop.entity.Game;
import bettingshop.entity.League;

@Stateless
public class OfficerManager {
	
	@PersistenceContext(unitName = "BettingServer")
	private EntityManager em;
	
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
