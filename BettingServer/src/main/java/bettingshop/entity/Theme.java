package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the theme database table.
 * 
 */
@Entity
@NamedQuery(name="Theme.findAll", query="SELECT t FROM Theme t")
public class Theme implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTeme;

	private String description;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date time;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="theme")
	@JsonIgnore
	private List<Comment> comments;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Theme() {
	}

	public int getIdTeme() {
		return this.idTeme;
	}

	public void setIdTeme(int idTeme) {
		this.idTeme = idTeme;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setTheme(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setTheme(null);

		return comment;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}