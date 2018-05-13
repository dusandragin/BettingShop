package bettingshop.data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import bettingshop.entity.Result;

/* 
 * Output data bean for showing current user tickets.
*/
public class UserTickets implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idTicket;
	private double potentionalWinnings;
	private double stake;
	private Date time;
	private double totalOdd;
	private boolean valid;
	private List<Result> results;

	public UserTickets() {

	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public double getPotentionalWinnings() {
		return potentionalWinnings;
	}

	public void setPotentionalWinnings(double potentionalWinnings) {
		this.potentionalWinnings = potentionalWinnings;
	}

	public double getStake() {
		return stake;
	}

	public void setStake(double stake) {
		this.stake = stake;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getTotalOdd() {
		return totalOdd;
	}

	public void setTotalOdd(double totalOdd) {
		this.totalOdd = totalOdd;
	}

	public String getValid() {
		if (this.valid) {
			return "valid";
		}else {
			return "not valid";
		}
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

}
