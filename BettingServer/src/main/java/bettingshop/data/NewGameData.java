package bettingshop.data;

import java.io.Serializable;
import java.util.Calendar;

import bettingshop.entity.Game;
import bettingshop.entity.League;
import bettingshop.entity.Team;

public class NewGameData implements Serializable{

	private static final long serialVersionUID = 1L;

	private int homeScore;
	private int awayScore;
	private String city;
	private double homeOdd;
	private double egalOdd;
	private double awayOdd;
	private String leagueName;
	private int idTeam1;
	private int idTeam2;
	
	public NewGameData() {
		super();
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getHomeOdd() {
		return homeOdd;
	}

	public void setHomeOdd(double homeOdd) {
		this.homeOdd = homeOdd;
	}

	public double getEgalOdd() {
		return egalOdd;
	}

	public void setEgalOdd(double egalOdd) {
		this.egalOdd = egalOdd;
	}

	public double getAwayOdd() {
		return awayOdd;
	}

	public void setAwayOdd(double awayOdd) {
		this.awayOdd = awayOdd;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public int getIdTeam1() {
		return idTeam1;
	}

	public void setIdTeam1(int idTeam1) {
		this.idTeam1 = idTeam1;
	}

	public int getIdTeam2() {
		return idTeam2;
	}

	public void setIdTeam2(int idTeam2) {
		this.idTeam2 = idTeam2;
	}
	
	public Game assignToGame(Team t1, Team t2, League league) {
		Game game = new Game();
		game.setHomeOdd(homeOdd);
		game.setEgalOdd(egalOdd);
		game.setAwayOdd(awayOdd);
		game.setCity(city);
		game.setHomeScore(homeScore);
		game.setAwayScore(awayScore);
		game.setTime(Calendar.getInstance().getTime());
		game.setLeague(league);
		game.setTeam1(t1);
		game.setTeam2(t2);
		return game;
	}
	
}
