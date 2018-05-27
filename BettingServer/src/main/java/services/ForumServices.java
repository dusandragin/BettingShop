package services;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bettingshop.data.CommentData;
import bettingshop.data.ThemeData;
import bettingshop.session.ForumManager;

@Path("/forum")
public class ForumServices {

	@Inject
	private ForumManager forumBean;

	@Path("/themes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllThemes() {
		return forumBean.getAllThemesWithComments();
	}

	@Path("/saveTheme")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveTheme(ThemeData themeData) {
		return forumBean.saveTheme(themeData);
	}

	
	@Path("/saveComment")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveComment(CommentData commentData) {
		return forumBean.saveComment(commentData);
	}

}
