package kladionica.session;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import kladionica.data.UserData;
import kladionica.entity.User;

@Stateless
@LocalBean
public class UserManager implements UserManagerLocal {
	@PersistenceContext(unitName = "KladionicaJPA")
	EntityManager em;

	@Override
	public String insertUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updatetUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changeCredit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserData getUserForUserName(String userName) {
		UserData userData = null;
		try {
			User user = null;
			List<User> l = em.createQuery("select u from User u where u.username =:userName")
					.setParameter("userName", userName).getResultList();
			if(!l.isEmpty()) {
				
				user = l.get(0);
			userData = new UserData(user.getName(), user.getSurname(), user.getUsername(), user.getEmail(),
						user.getCredit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userData;
	}

}
