package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Filter;

public class FilterDao {
	
	private static String PERSISTENCE_UNIT_NAME = "persistence";
	EntityManager em;
	EntityManagerFactory factory;
	
	public FilterDao() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
	}

	public void addFilter(Filter f){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(f);
		et.commit();
		em.close();
		factory.close();
	}
}
