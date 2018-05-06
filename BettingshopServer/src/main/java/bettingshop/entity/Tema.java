package bettingshop.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tema database table.
 * 
 */
@Entity
@NamedQuery(name="Tema.findAll", query="SELECT t FROM Tema t")
public class Tema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTeme;

	private String naslovTeme;

	private String opisTeme;

	@Temporal(TemporalType.TIMESTAMP)
	private Date vremeidatum;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="tema")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Tema() {
	}

	public int getIdTeme() {
		return this.idTeme;
	}

	public void setIdTeme(int idTeme) {
		this.idTeme = idTeme;
	}

	public String getNaslovTeme() {
		return this.naslovTeme;
	}

	public void setNaslovTeme(String naslovTeme) {
		this.naslovTeme = naslovTeme;
	}

	public String getOpisTeme() {
		return this.opisTeme;
	}

	public void setOpisTeme(String opisTeme) {
		this.opisTeme = opisTeme;
	}

	public Date getVremeidatum() {
		return this.vremeidatum;
	}

	public void setVremeidatum(Date vremeidatum) {
		this.vremeidatum = vremeidatum;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setTema(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setTema(null);

		return komentar;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}