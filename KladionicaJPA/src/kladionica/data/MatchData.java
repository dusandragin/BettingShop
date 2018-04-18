package kladionica.data;

import java.util.Date;
import kladionica.entity.League;
import kladionica.entity.Team;


public class MatchData {
	private double awayOdd;
	private String city;
	private double egalOdd;
	private double homeOdd;
	private Date time;
	private League league;	
	private Team team1;
	private Team team2;
	public MatchData(double awayOdd, String city, double egalOdd, double homeOdd, Date time,
			League league, Team team1, Team team2) {
		this.awayOdd = awayOdd;
		this.city = city;
		this.egalOdd = egalOdd;
		this.homeOdd = homeOdd;
		this.time = time;
		this.league = league;
		this.team1 = team1;
		this.team2 = team2;
	}
	public double getAwayOdd() {
		return awayOdd;
	}
	public void setAwayOdd(double awayOdd) {
		this.awayOdd = awayOdd;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getEgalOdd() {
		return egalOdd;
	}
	public void setEgalOdd(double egalOdd) {
		this.egalOdd = egalOdd;
	}
	public double getHomeOdd() {
		return homeOdd;
	}
	public void setHomeOdd(double homeOdd) {
		this.homeOdd = homeOdd;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public League getLeague() {
		return league;
	}
	public void setLeague(League league) {
		this.league = league;
	}
	public Team getTeam1() {
		return team1;
	}
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}
	public Team getTeam2() {
		return team2;
	}
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}
	
	
}

