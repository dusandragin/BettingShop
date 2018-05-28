package bettingshop.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdminManager {

	@PersistenceContext(unitName = "BettingServer")
	private EntityManager em;
	
	public AdminManager() {}

	
	
	
}
