package kladionica.session;

import kladionica.data.UserData;

public interface UserManagerLocal {
	public String insertUser();
	public String updatetUser();
	public String changeCredit();
	public UserData getUserForUserName(String userName);
}
