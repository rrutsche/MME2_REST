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

	public boolean createFilter(Filter f){
		
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
		return true;
	}
	
	public Filter readFilter(long id){
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Filter filter = (Filter) em.find(Filter.class, id);
		
		et.commit();
		em.close();
		factory.close();
		return filter;
	}
	
	public boolean updateFilter(Filter f){
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(f);
		et.commit();
		em.close();
		factory.close();
		return true;
	}
	
	public boolean deleteFilter(long id){
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Filter filter = (Filter) em.find(Filter.class, id);
		if (filter == null) {
			return false;
		}
		em.remove(filter);
		et.commit();
		em.close();
		factory.close();
		return true;
		
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
