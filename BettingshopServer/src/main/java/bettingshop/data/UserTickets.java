package bettingshop.data;

import java.io.Serializable;
import java.util.List;

import bettingshop.entity.Ticket;

public class UserTickets implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Ticket> tickets;
	
	public UserTickets() {

	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
