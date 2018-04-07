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
		user.setEmail("dragin.dusan@gmil.com");
		user.setName("Dusan");
		user.setSurname("Dragin");
		user.setUsername("dusandragin");
		user.setPassword("dusan");
		
		em.persist(user);
		et.commit();
		em.close();
	}
}
