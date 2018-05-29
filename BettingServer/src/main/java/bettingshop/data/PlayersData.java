package bettingshop.data;

import java.util.List;

import bettingshop.entity.Player;

public class PlayersData {

	private List<Player> playersTeam1;
	private List<Player> playersTeam2;
	
	public PlayersData() {
		// TODO Auto-generated constructor stub
	}

	public List<Player> getPlayersTeam1() {
		return playersTeam1;
	}

	public void setPlayersTeam1(List<Player> playersTeam1) {
		this.playersTeam1 = playersTeam1;
	}

	public List<Player> getPlayersTeam2() {
		return playersTeam2;
	}

	public void setPlayersTeam2(List<Player> playersTeam2) {
		this.playersTeam2 = playersTeam2;
	}
	
}
