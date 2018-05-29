package bettingshop.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the league database table.
 * 
 */
@Entity
@NamedQuery(name="League.findAll", query="SELECT l FROM League l")
public class League implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLeague;

	private String name;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="league")
	@JsonIgnore
	private List<Game> games;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-many association to Team
	@ManyToMany(mappedBy="leagues")
	@JsonIgnore
	private List<Team> teams;

	public League() {
	}

	public int getIdLeague() {
		return this.idLeague;
	}

	public void setIdLeague(int idLeague) {
		this.idLeague = idLeague;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return this.games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Game addGame(Game game) {
		getGames().add(game);
		game.setLeague(this);

		return game;
	}

	public Game removeGame(Game game) {
		getGames().remove(game);
		game.setLeague(null);

		return game;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}