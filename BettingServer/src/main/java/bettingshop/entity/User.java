package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private double credit;

	private String email;

	private String lastname;

	private String name;

	private String password;

	private String role;

	private String username;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Comment> comments;

	//bi-directional many-to-one association to Theme
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Theme> themes;

	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Ticket> tickets;

	public User() {
	}
	
	public User(String name, String lastname, 
		    String username, String email, 
		    String password, double credit, String role) {
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.credit = credit;
		this.role = role;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public double getCredit() {
		return this.credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Theme> getThemes() {
		return this.themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme addTheme(Theme theme) {
		getThemes().add(theme);
		theme.setUser(this);

		return theme;
	}

	public Theme removeTheme(Theme theme) {
		getThemes().remove(theme);
		theme.setUser(null);

		return theme;
	}

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setUser(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setUser(null);

		return ticket;
	}

}