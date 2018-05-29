package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlayer;

	private String lastName;

	private String name;

	private int number;

	private String position;

	//bi-directional many-to-one association to Team
	@ManyToOne
	private Team team;

	public Player() {
	}

	public int getIdPlayer() {
		return this.idPlayer;
	}

	public void setIdPlayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}