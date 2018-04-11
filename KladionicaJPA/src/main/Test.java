package main;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.User;

public class Test {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KladionicaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = new User();
		user.setEmail("pera.peric@gmail.com");
		user.setName("Pera");
		user.setSurname("Peric");
		user.setUsername("peraperic");
		user.setPassword("pera");
		
		em.persist(user);
		et.commit();
		em.close();
	}
}
