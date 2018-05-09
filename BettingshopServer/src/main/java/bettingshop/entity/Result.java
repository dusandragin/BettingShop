package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ResultPK id;

	private int result;

	//bi-directional many-to-one association to Game
	@ManyToOne
	@JoinColumn(name="Match_idMatch")
	private Game game;

	//bi-directional many-to-one association to Ticket
	@ManyToOne
	@JoinColumn(name="Ticket_idTicket")
	private Ticket ticket;

	public Result() {
	}

	public ResultPK getId() {
		return this.id;
	}

	public void setId(ResultPK id) {
		this.id = id;
	}

	public int getResult() {
		return this.result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}