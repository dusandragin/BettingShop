package main;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import kladionica.entity.User;
import utils.DigestPasswordUtil;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("KladionicaJPA");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		et.begin();
//		User user = new User();
//		user.setEmail("komsa.zokic@gmail.com");
//		user.setName("Zoki");
//		user.setSurname("ac");
//		user.setUsername("zoki");
//		user.setPassword("zoki");
//		
//		em.persist(user);
//		et.commit();
//		em.close();
		
		String hashPassword = DigestPasswordUtil.hashPassword("asdf", DigestPasswordUtil.MD5);
		System.out.println(hashPassword);
	}
}
