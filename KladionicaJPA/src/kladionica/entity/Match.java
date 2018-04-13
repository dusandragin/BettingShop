package kladionica.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the match database table.
 * 
 */
@Entity
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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

	//bi-directional many-to-many association to Ticket
	@ManyToMany(mappedBy="matches")
	private List<Ticket> tickets;

	public Match() {
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

	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}