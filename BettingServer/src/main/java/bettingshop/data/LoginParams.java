package bettingshop.data;

/*
 * Input data bean for determining current user 
 * from client side 
*/
public class LoginParams {
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public LoginParams() {
	}
	
}
