package kladionica.entity;
// Generated May 4, 2018 6:56:20 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ticket generated by hbm2java
 */
@Entity
@Table(name = "ticket", catalog = "kladionica")
public class Ticket implements java.io.Serializable {

	private Integer idTicket;
	private User user;
	private Double stake;
	private Double potentionalWinnings;
	private Double totalOdd;
	private Boolean valid;
	private Date time;
	private Set<Match> matches = new HashSet<Match>(0);

	public Ticket() {
	}

	public Ticket(User user) {
		this.user = user;
	}

	public Ticket(User user, Double stake, Double potentionalWinnings, Double totalOdd, Boolean valid, Date time,
			Set<Match> matches) {
		this.user = user;
		this.stake = stake;
		this.potentionalWinnings = potentionalWinnings;
		this.totalOdd = totalOdd;
		this.valid = valid;
		this.time = time;
		this.matches = matches;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTicket", unique = true, nullable = false)
	public Integer getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(Integer idTicket) {
		this.idTicket = idTicket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "User_idUser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "stake", precision = 22, scale = 0)
	public Double getStake() {
		return this.stake;
	}

	public void setStake(Double stake) {
		this.stake = stake;
	}

	@Column(name = "potentionalWinnings", precision = 22, scale = 0)
	public Double getPotentionalWinnings() {
		return this.potentionalWinnings;
	}

	public void setPotentionalWinnings(Double potentionalWinnings) {
		this.potentionalWinnings = potentionalWinnings;
	}

	@Column(name = "totalOdd", precision = 22, scale = 0)
	public Double getTotalOdd() {
		return this.totalOdd;
	}

	public void setTotalOdd(Double totalOdd) {
		this.totalOdd = totalOdd;
	}

	@Column(name = "valid")
	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "time", length = 10)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "ticket_has_match", catalog = "kladionica", joinColumns = {
			@JoinColumn(name = "Ticket_idTicket", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Match_idMatch", nullable = false, updatable = false) })
	public Set<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

}
