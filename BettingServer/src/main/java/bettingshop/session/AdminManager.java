package bettingshop.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import bettingshop.data.NewGameData;
import bettingshop.entity.Game;
import bettingshop.entity.League;
import bettingshop.entity.Team;

@Stateless
public class AdminManager {

	@PersistenceContext(unitName = "BettingServer")
	private EntityManager em;
	
	public AdminManager() {}

	@SuppressWarnings("unchecked")
	public Response getAllTeamsForLeague(String league) {
		List<Team> teams = em.createQuery("select t from Team t join t.leagues l where l.name =:ln")
				.setParameter("ln", league).getResultList();
		return Response.ok(teams).build();
	}

	public Response saveGame(NewGameData body) {
		Team team1 = em.find(Team.class, body.getIdTeam1());
		Team team2 = em.find(Team.class, body.getIdTeam2());
		League league = (League) em.createQuery("select l from League l where l.name =:ln")
								   .setParameter("ln", body.getLeagueName())
								   .getSingleResult();
		Game newGame = body.assignToGame(team1, team2, league);
		em.persist(newGame);
		return Response.ok(newGame).build();
	}
	
}
