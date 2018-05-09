package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the team database table.
 * 
 */
@Entity
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTeam;

	private String city;

	private String name;

	private String stadium;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="team1")
	@JsonIgnore
	private List<Game> games1;

	//bi-directional many-to-one association to Game
	@OneToMany(mappedBy="team2")
	@JsonIgnore
	private List<Game> games2;

	//bi-directional many-to-many association to League
	@ManyToMany
	@JoinTable(
		name="team_has_league"
		, joinColumns={
			@JoinColumn(name="Team_idTeam")
			}
		, inverseJoinColumns={
			@JoinColumn(name="League_idLeague")
			}
		)
	@JsonIgnore
	private List<League> leagues;

	public Team() {
	}

	public int getIdTeam() {
		return this.idTeam;
	}

	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStadium() {
		return this.stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public List<Game> getGames1() {
		return this.games1;
	}

	public void setGames1(List<Game> games1) {
		this.games1 = games1;
	}

	public Game addGames1(Game games1) {
		getGames1().add(games1);
		games1.setTeam1(this);

		return games1;
	}

	public Game removeGames1(Game games1) {
		getGames1().remove(games1);
		games1.setTeam1(null);

		return games1;
	}

	public List<Game> getGames2() {
		return this.games2;
	}

	public void setGames2(List<Game> games2) {
		this.games2 = games2;
	}

	public Game addGames2(Game games2) {
		getGames2().add(games2);
		games2.setTeam2(this);

		return games2;
	}

	public Game removeGames2(Game games2) {
		getGames2().remove(games2);
		games2.setTeam2(null);

		return games2;
	}

	public List<League> getLeagues() {
		return this.leagues;
	}

	public void setLeagues(List<League> leagues) {
		this.leagues = leagues;
	}

}