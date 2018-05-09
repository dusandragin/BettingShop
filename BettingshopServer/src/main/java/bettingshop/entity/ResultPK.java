package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the result database table.
 * 
 */
@Embeddable
public class ResultPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int match_idMatch;

	@Column(insertable=false, updatable=false)
	private int ticket_idTicket;

	public ResultPK() {
	}
	public int getMatch_idMatch() {
		return this.match_idMatch;
	}
	public void setMatch_idMatch(int match_idMatch) {
		this.match_idMatch = match_idMatch;
	}
	public int getTicket_idTicket() {
		return this.ticket_idTicket;
	}
	public void setTicket_idTicket(int ticket_idTicket) {
		this.ticket_idTicket = ticket_idTicket;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ResultPK)) {
			return false;
		}
		ResultPK castOther = (ResultPK)other;
		return 
			(this.match_idMatch == castOther.match_idMatch)
			&& (this.ticket_idTicket == castOther.ticket_idTicket);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.match_idMatch;
		hash = hash * prime + this.ticket_idTicket;
		
		return hash;
	}
}