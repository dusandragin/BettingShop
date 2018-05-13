package bettingshop.data;

import java.io.Serializable;

public class GameData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String team1;
	private String team2;
	private int idMatch;
	private double odd;
	private int result;
	
	
	
	public GameData() {

	}
	public GameData(String team1, String team2, int idMatch, double odd, int result) {
		super();
		this.team1 = team1;
		this.team2 = team2;
		this.idMatch = idMatch;
		this.odd = odd;
		this.result = result;
	}
	public String getTeam1() {
		return team1;
	}
	public void setTeam1(String team1) {
		this.team1 = team1;
	}
	public String getTeam2() {
		return team2;
	}
	public void setTeam2(String team2) {
		this.team2 = team2;
	}
	public int getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	public double getOdd() {
		return odd;
	}
	public void setOdd(double odd) {
		this.odd = odd;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	

}
