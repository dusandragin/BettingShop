package bettingshop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the ticket database table.
 * 
 */
@Entity
@NamedQuery(name="Ticket.findAll", query="SELECT t FROM Ticket t")
public class Ticket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTicket;

	private double potentionalWinnings;

	private double stake;

	@Temporal(TemporalType.DATE)
	private Date time;

	private double totalOdd;

	private boolean valid;

	//bi-directional many-to-one association to Result
	@OneToMany(mappedBy="ticket")
	@JsonIgnore
	private List<Result> results;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	private int status;

	public Ticket() {
	}

	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
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

	public boolean getValid() {
		return this.valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<Result> getResults() {
		return this.results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Result addResult(Result result) {
		getResults().add(result);
		result.setTicket(this);

		return result;
	}

	public Result removeResult(Result result) {
		getResults().remove(result);
		result.setTicket(null);

		return result;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}