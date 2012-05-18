package service;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import domain.Filter;

public class DataProvider {
	
	static private DataProvider instance;
	static ArrayList<Filter> filterList;
	static ObjectMapper mapper; 
	
	private DataProvider(){
		filterList = new ArrayList<Filter>();
		mapper = new ObjectMapper();
		Filter f = new Filter("NasenFilter", 80, 70, 65, 200, 130, 60, false);
		Filter fi = new Filter("OhrenFilter", 80, 70, 65, 200, 130, 60, false);
		setFilter(f);
		setFilter(fi);
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
	
	public Filter getFilterById(int i){
		for (Filter filter : filterList) {
			if(filter.getId() == i) return filter;
		}
		return null;
	}
	
	public Filter getFilterByName(String name){
		for (Filter filter : filterList) {
			if(name.equals(filter.getName())) return filter;
		}
		return null;
	}
	
	public Filter setFilter(Filter newFilter){
		for (Filter filter : filterList) {
			if(newFilter.getName().equals(filter.getName())){
				return null;
			}
		}
		newFilter.setId(filterList.size());
		filterList.add(newFilter.getId(), newFilter);
		return newFilter;
	}
	
	public String filterListToString(){
		StringBuilder back = new StringBuilder();
		for (Filter filter : filterList) {
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
}
