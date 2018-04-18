package main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kladionica.entity.User;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KladionicaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = new User();
		user.setEmail("komsa.zokic@gmail.com");
		user.setName("Zoki");
		user.setLastname("ac");
		user.setUsername("zoki");
		user.setPassword("zoki");
		user.setRole("konj");
		
		em.persist(user);
		et.commit();
		em.close();
	}
}
