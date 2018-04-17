package kladionica.data;

public class UserData {

	private double credit;

	private String email;

	private String name;

	private String password;

	private String surname;

	private String username;

	public UserData() {
	}

	public UserData(double credit, String email, String name, String password, String surname, String username) {
		this.credit = credit;
		this.email = email;
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.username = username;
	}

	public UserData(String name, String surname, String username, String email, double credit) {
		this.credit = credit;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.username = username;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
