package bettingshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the game database table.
 * 
 */
@Entity
@NamedQuery(name="Game.findAll", query="SELECT g FROM Game g")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMatch;

	private double awayOdd;

	private int awayScore;

	private String city;

	private double egalOdd;

	private double homeOdd;

	private int homeScore;

	@Temporal(TemporalType.DATE)
	private Date time;

	//bi-directional many-to-one association to League
	@ManyToOne
	private League league;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="HomeTeam_idTeam")
	private Team team1;

	//bi-directional many-to-one association to Team
	@ManyToOne
	@JoinColumn(name="AwayTeam_idTeam")
	private Team team2;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="game")
	@JsonIgnore
	private List<Result> results;

	public Game() {
	}

	public int getIdMatch() {
		return this.idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}

	public double getAwayOdd() {
		return this.awayOdd;
	}

	public void setAwayOdd(double awayOdd) {
		this.awayOdd = awayOdd;
	}

	public int getAwayScore() {
		return this.awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getEgalOdd() {
		return this.egalOdd;
	}

	public void setEgalOdd(double egalOdd) {
		this.egalOdd = egalOdd;
	}

	public double getHomeOdd() {
		return this.homeOdd;
	}

	public void setHomeOdd(double homeOdd) {
		this.homeOdd = homeOdd;
	}

	public int getHomeScore() {
		return this.homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public League getLeague() {
		return this.league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setGame(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setGame(null);

		return result;
	}

}