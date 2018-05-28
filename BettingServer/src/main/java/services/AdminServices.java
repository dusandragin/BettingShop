package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bettingshop.data.NewGameData;
import bettingshop.session.AdminManager;

@Path("/admin")
public class AdminServices {

	@Inject
	private AdminManager adminBean;
	
	
	@Path("/teamsForLeague/{league}")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCategories(@PathParam (value = "league") String league) {
		return adminBean.getAllTeamsForLeague(league);
	}
	
	@Path("/saveGame")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveGame(NewGameData body) {
		return adminBean.saveGame(body);
	}
	
}
