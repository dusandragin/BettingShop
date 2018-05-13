package bettingshop.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.Response;

import bettingshop.data.CommentData;
import bettingshop.data.ThemeData;
import bettingshop.entity.Comment;
import bettingshop.entity.Theme;
import bettingshop.entity.User;
import bettingshop.util.DateUtil;

/**
 * Local Session Bean implementation class ForumManager
 * Implements logic for ForumServices
 * 
 */
@Stateless
@LocalBean
public class ForumManager {

	@PersistenceContext(unitName = "BettingServer")
	private EntityManager em;

	public ForumManager() {
	}

	public Response getAllComments() {
		return Response.ok(em.createNamedQuery("Comment.findAll")
					         .getResultList()).build();
	}

	@SuppressWarnings("unchecked")
	public Response getAllThemesWithComments() {
		List<ThemeData> resultList = new ArrayList<>();
		List<Theme> themes = em.createNamedQuery("Theme.findAll")
							   .getResultList();
		for (Theme theme : themes) {
			ThemeData tData = new ThemeData();
			tData.setIdTeme(theme.getIdTeme());
			tData.setDescription(theme.getDescription());
			tData.setName(theme.getName());
			tData.setTime(theme.getTime());
			tData.setUser(theme.getUser());
			List<Comment> comments = em.createQuery("select c from Comment c "
											      + "where c.theme =:theme")
									   .setParameter("theme", theme)
									   .getResultList();
			tData.setComments(comments);
			resultList.add(tData);
		}
		return Response.ok(resultList).build();
	}
	
	@SuppressWarnings("unchecked")
	public Response saveComment(CommentData commentData) {
		Theme t = em.find(Theme.class, commentData.getIdTheme());
		User u = em.find(User.class, commentData.getIdUser());
		Comment newComment = new Comment();
		newComment.setContent(commentData.getCommentContent());
		newComment.setTheme(t);
		newComment.setUser(u);
		newComment.setTime(DateUtil.getCurrDate());
		em.persist(newComment);
		// Refresh data on client - get all themes with comments
		List<ThemeData> resultList = new ArrayList<>();
		List<Theme> themes = em.createNamedQuery("Theme.findAll")
							   .getResultList();
		for (Theme theme : themes) {
			ThemeData tData = new ThemeData();
			tData.setIdTeme(theme.getIdTeme());
			tData.setDescription(theme.getDescription());
			tData.setName(theme.getName());
			tData.setTime(theme.getTime());
			tData.setUser(theme.getUser());
			List<Comment> comments = em.createQuery("select c from Comment c "
											      + "where c.theme =:theme")
									   .setParameter("theme", theme)
									   .getResultList();
			tData.setComments(comments);
			resultList.add(tData);
		}
		return Response.ok(resultList).build();
	}
}


