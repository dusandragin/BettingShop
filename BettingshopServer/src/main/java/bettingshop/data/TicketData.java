package bettingshop.data;

import java.io.Serializable;
import java.util.List;

import bettingshop.entity.User;

public class TicketData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GameData> games ;
	private User user;
	private Double sum;
	
	public TicketData(List<GameData> games, User user, Double sum) {
		super();
		this.games = games;
		this.user = user;
		this.sum = sum;
	}
	public TicketData() {
		super();
	}
	public List<GameData> getGames() {
		return games;
	}
	public void setGames(List<GameData> games) {
		this.games = games;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	
	
	
}
