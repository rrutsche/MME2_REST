package service;

import java.util.ArrayList;
import java.util.List;

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

	public void createFilter(Filter f){
		
		EntityTransaction et = em.getTransaction();
		boolean filterIsUnique = true;
		et.begin();

		Filter[] filters = getAll();
		for (Filter filter : filters) {
			if (filter.getName().equals(f.getName())){
				filterIsUnique = false;
			}
		}
		
		if (filterIsUnique) {
			em.persist(f);
		}
		et.commit();
		em.close();
		factory.close();
	}
	
	public Filter readFilter(int id){
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		return null;
	}
	
	public void updateFilter(Filter f){
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(f);
		et.commit();
		em.close();
		factory.close();
		
	}
	
	public void deleteFilter(int id){
		
	}
	
	public Filter[] getAll() {
		ArrayList<Filter> filters = new ArrayList<Filter>();
		
		List<?> loadedFilters = em.createQuery("select f from Filter f").getResultList();
		
		for (Object filter: loadedFilters) {
			if(filter instanceof Filter){
				Filter loadedFilter = (Filter) filter;
				filters.add(loadedFilter);
				System.out.println(loadedFilter.getName());
			}
		}
		return filters.toArray(new Filter[0]);
	}
}
