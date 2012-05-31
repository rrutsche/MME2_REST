package service;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.codehaus.jackson.map.ObjectMapper;

import domain.FilterDto;

public class DataProvider {
	
	static private DataProvider instance;
	static ArrayList<FilterDto> filterList;
	static ObjectMapper mapper; 
	static EntityManagerFactory factory;
    static EntityManager em; 
	

	private DataProvider(){
		filterList = new ArrayList<FilterDto>();
		mapper = new ObjectMapper();
	}
	
	static public DataProvider getInstance(){
		if(instance == null){
			instance = new DataProvider();
			return instance;
		}else{
			return instance;
		}
	}
	
	public ObjectMapper getMapper() {
		return mapper;
	}
	
	public FilterDto getFilterById(int i){
		for (FilterDto filter : filterList) {
			if(filter.getId() == i) return filter;
		}
		return null;
	}
	
	public FilterDto getFilterByName(String name){
		for (FilterDto filter : filterList) {
			if(name.equals(filter.getName())) return filter;
		}
		return null;
	}
	
//	public FilterDto setFilter(FilterDto newFilter){
//		for (FilterDto filter : filterList) {
//			if(newFilter.getName().equals(filter.getName())){
//				return null;
//			}
//		}
//		newFilter.setId(filterList.size());
//		filterList.add(newFilter.getId(), newFilter);
//		return newFilter;
//	}
	
	public String filterListToString(){
		StringBuilder back = new StringBuilder();
		for (FilterDto filter : filterList) {
			back.append(filter.toString()+"\n");
		}
		return back.toString();
	}
	
	public void removeFilter(String name){
		for (int i = 0; i < filterList.size(); i++) {
			if(name.equals(filterList.get(i).getName())){
				filterList.remove(i);
				break;
			}
			System.out.println("filterList after removing object: \n");
			System.out.println(filterListToString());
		}
	}
	
	public boolean nameIsUnique(String name){
		for (FilterDto filter : filterList) {
			if(name.equals(filter.getName())){
				return false;
			}
		}
		return true;
	}
}
