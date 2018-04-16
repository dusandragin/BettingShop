package kladionica.session.remote;

import javax.ejb.Remote;

import kladionica.data.UserData;

@Remote
public interface UserManagerRemote {

	public UserData getUserForUserName(String userName);
	
}
