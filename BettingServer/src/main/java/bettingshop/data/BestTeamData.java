package bettingshop.data;

import java.util.Date;

public class BestTeamData {
	
	private String team;
	private String city;
	private int winsNum;
	
	public BestTeamData() {
	}
		
	public BestTeamData(String team, String city, int winsNum) {
		super();
		this.team = team;
		this.city = city;
		this.winsNum = winsNum;
	}

	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getWinsNum() {
		return winsNum;
	}

	public void setWinsNum(int winsNum) {
		this.winsNum = winsNum;
	}
	
	
	

}
