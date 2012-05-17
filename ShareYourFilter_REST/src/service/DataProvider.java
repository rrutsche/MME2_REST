package service;

import java.util.ArrayList;

import domain.Filter;

public class DataProvider {
	
	static private DataProvider instance;
	static ArrayList<Filter> filterList;
	
	private DataProvider(){
		filterList = new ArrayList<Filter>();
		Filter f = new Filter("NasenFilter", 80, 70, 65, 200, 130, 60, false);
		filterList.add(f);
	}
	
	static public DataProvider getInstance(){
		if(instance == null){
			instance = new DataProvider();
			return instance;
		}else{
			return instance;
		}
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
			}else{
				newFilter.setId(filterList.size());
				filterList.add(newFilter.getId(), newFilter);
				return newFilter;
			}
		}
		return null;
	}
}
