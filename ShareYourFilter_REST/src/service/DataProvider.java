package service;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

import domain.Filter;
import domain.FilterDto;

public class DataProvider {
	
	static private DataProvider instance;
	static ArrayList<FilterDto> filterList;
	static ObjectMapper mapper; 
	static FilterDao filterDao;

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
	
	public Filter getFilterById(long id){
		filterDao = new FilterDao();
		return filterDao.readFilter(id);
	}
	
	public Filter[] getAllFilters(){
		filterDao = new FilterDao();
		return filterDao.getAll();
	}
	
	public FilterDto getFilterByName(String name){
		for (FilterDto filter : filterList) {
			if(name.equals(filter.getName())) return filter;
		}
		return null;
	}
	
	public FilterDto setFilter(FilterDto newFilter){
		for (FilterDto filter : filterList) {
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
		for (FilterDto filter : filterList) {
			back.append(filter.toString()+"\n");
		}
		return back.toString();
	}
	
	public void updateFilter(Filter f){
		filterDao = new FilterDao();
		filterDao.updateFilter(f);
	}
	
	public void removeFilter(long id){
		filterDao = new FilterDao();
		filterDao.deleteFilter(id);
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
