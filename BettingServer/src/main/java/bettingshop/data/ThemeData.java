package bettingshop.data;

import java.util.Date;
import java.util.List;

import bettingshop.entity.Comment;
import bettingshop.entity.User;

/*
 * Output data bean for themes on forum
*/
public class ThemeData {

	private int idTeme;
	private String description;
	private String name;
	private Date time;
	private User user;
	private List<Comment> comments;

	public ThemeData() {
	}

	public int getIdTeme() {
		return idTeme;
	}

	public void setIdTeme(int idTeme) {
		this.idTeme = idTeme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}