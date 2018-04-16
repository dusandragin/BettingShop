package main;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kladionica.entity.User;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KladionicaJPA");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		User user = new User();
		user.setEmail("komsa.zokic@gmail.com");
		user.setName("Zoki");
		user.setLastname("ac");
		user.setUsername("zoki");
		user.setPassword("f445dd9bc7880bc2ce62de6e7dca89d0");
		
		em.persist(user);
		et.commit();
		em.close();
		
//		String hashPassword = DigestPasswordUtil.hashPassword("zoki", DigestPasswordUtil.MD5);
//		System.out.println(hashPassword);
	}
}
