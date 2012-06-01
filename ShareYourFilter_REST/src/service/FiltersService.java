package service;

import java.io.IOException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import util.JSONConverter;
import domain.Filter;

@Path("/filters")
public class FiltersService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
		
		@GET
		@Path("/{id}")
		@Produces({MediaType.APPLICATION_JSON})
		public String getFilter(@PathParam("id") long id) throws JsonGenerationException, JsonMappingException, IOException{
			System.out.println("################################# GET");
			
			Filter filter = DataProvider.getInstance().getFilterById(id);
			if(filter != null){
				System.out.println(filter.toString());
				return JSONConverter.filterToJson(filter);
			}
			return null;
		}
		
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		public String getFilters() throws JsonGenerationException, JsonMappingException, IOException{
			System.out.println("################################# GET");
			
			System.out.println("get all");
			Filter[] filters = DataProvider.getInstance().getAllFilters();
			
			if (filters.length > 0) {
				return JSONConverter.filterArrayToJson(filters);
			}
			
			return null;
		}
		
		@PUT
		@Produces(MediaType.TEXT_HTML)
		public void setFilter(@PathParam("name") String name, String jsonString) throws JsonParseException, JsonMappingException, IOException{
			System.out.println("################################# PUT");
			FilterDao fd = new FilterDao();
			fd.createFilter(JSONConverter.jsonToFilter(jsonString));
			
//			if(null == DataProvider.getInstance().setFilter(JSONConverter.jsonToFilterDto(jsonString))){
//				System.out.println("Something went wrong while persisting filter object");
//			}
			
			System.out.println("FilterList:\n");
			System.out.println(DataProvider.getInstance().filterListToString());
		}
		
		@POST
		@Produces(MediaType.TEXT_HTML)
		public void updateFilter(@PathParam("id") long id, String jsonString) throws JsonParseException, JsonMappingException, IOException{
			System.out.println("################################# POST");
			
			DataProvider.getInstance().updateFilter(JSONConverter.jsonToFilter(jsonString));
			
//			FilterDto newFilterObject = JSONConverter.jsonToFilter(jsonString);
//			FilterDto oldFilterObject = DataProvider.getInstance().getFilterByName(name);
//			
//			if(DataProvider.getInstance().nameIsUnique(newFilterObject.getName())){
//				if (null != oldFilterObject) {	
//					oldFilterObject.setName(newFilterObject.getName());
//					oldFilterObject.setBlue(newFilterObject.getBlue());
//					oldFilterObject.setGreen(newFilterObject.getGreen());
//					oldFilterObject.setRed(newFilterObject.getRed());
//					oldFilterObject.setBrightness(newFilterObject.getBrightness());
//					oldFilterObject.setSaturation(newFilterObject.getSaturation());
//					oldFilterObject.setContrast(newFilterObject.getContrast());
//					oldFilterObject.setNegative(newFilterObject.isNegative());
//					System.out.println("oldfilterObject: "+oldFilterObject.toString());
//				}else{
//					System.out.println("Something went wrong during filter object update process");
//				}
//			}else{
//				System.out.println("Filter name is not unique");
//			}
//			System.out.println(DataProvider.getInstance().filterListToString());
		}
		
		@DELETE
		@Produces(MediaType.TEXT_HTML)
		public void deleteFilter(@PathParam("id") long id){
			System.out.println("################################# DELETE");
			
			DataProvider.getInstance().removeFilter(id);
		}
}
