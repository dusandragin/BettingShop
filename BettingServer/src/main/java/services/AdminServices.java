package services;

import javax.inject.Inject;
import javax.ws.rs.Path;

import bettingshop.session.AdminManager;

@Path("/admin")
public class AdminServices {

	@Inject
	private AdminManager adminBean;
	
	
	
	
}
