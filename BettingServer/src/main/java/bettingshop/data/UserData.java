package bettingshop.data;

/*
 * Input data bean for inserting new user
*/
public class UserData {

	private double credit;
	private String lastname;
	private String name;
	private String email;
	private String password;
	private String username;

	public UserData(double credit, String email, 
				    String name, String password, 
				    String lastname, String username) {
		this.credit = credit;
		this.email = email;
		this.name = name;
		this.password = password;
		this.lastname = lastname;
		this.username = username;
	}

	public UserData(double credit, String email, 
					String name, String lastname, 
					String username) {
		this.credit = credit;
		this.email = email;
		this.name = name;
		this.lastname = lastname;
		this.username = username;

	}

	public UserData() {

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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
