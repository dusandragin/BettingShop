package kladionica.data;

public class AdminData {
	
	private String name;

	private String password;
	
	private String surname;
	
	private String username;
	
	public AdminData(String name, String password, String surname, String username) {
		this.name = name;
		this.password = password;
		this.surname = surname;
		this.username = username;
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
