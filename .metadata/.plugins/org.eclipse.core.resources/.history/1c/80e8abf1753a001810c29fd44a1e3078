package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTicket;

	private double potentionalWinnings;

	private double stake;

	@Temporal(TemporalType.DATE)
	private Date time;

	private double totalOdd;

	private byte valid;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-many association to Match
	@ManyToMany
	@JoinTable(
		name="ticket_has_match"
		, joinColumns={
			@JoinColumn(name="Ticket_idTicket")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Match_idMatch")
			}
		)
	private List<Match> matches;

	public Ticket() {
	}

	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public double getPotentionalWinnings() {
		return this.potentionalWinnings;
	}

	public void setPotentionalWinnings(double potentionalWinnings) {
		this.potentionalWinnings = potentionalWinnings;
	}

	public double getStake() {
		return this.stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getTotalOdd() {
		return this.totalOdd;
	}

	public void setTotalOdd(double totalOdd) {
		this.totalOdd = totalOdd;
	}

	public byte getValid() {
		return this.valid;
	}

	public void setValid(byte valid) {
		this.valid = valid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}