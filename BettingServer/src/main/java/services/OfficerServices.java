package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bettingshop.session.OfficerManager;

@Path("officer")
public class OfficerServices {

	@Inject
	private OfficerManager officerBean;

	@Path("/allCategories")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories() {
		return officerBean.getAllCategories();
	}

	@Path("/gamesForCategory/{category}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGamesForCategory(@PathParam(value = "category") String category) {
		return officerBean.getGamesForCategory(category);
	}

	@Path("/leaguesForCategory/{category}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLeaguesForCategory(@PathParam(value = "category") String category) {
		return officerBean.getLeaguesForCategory(category);
	}

	@Path("/gamesForLeague/{league}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGamesForLeague(@PathParam(value = "league") String league) {
		return officerBean.getGamesForLeague(league);
	}

}
