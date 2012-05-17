package service;

import java.util.ArrayList;

import domain.Filter;

public class ConnectionManager {
	
	private ConnectionManager instance;
	ArrayList<Filter> filterList;
	
	private ConnectionManager(){
		filterList = new ArrayList<Filter>();
	}
	
	public ConnectionManager getInstance(){
		if(instance == null){
			instance = new ConnectionManager();
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
