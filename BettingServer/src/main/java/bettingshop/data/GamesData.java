package bettingshop.data;

import java.io.Serializable;
import java.util.List;

import bettingshop.entity.Game;

public class GamesData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Game> games;
	public List<Game> getGames() {
		return games;
	}
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
}
