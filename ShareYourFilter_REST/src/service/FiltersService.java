package service;

import java.io.IOException;

import javax.ws.rs.Consumes;
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

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import domain.Filter;

@Path("/filters/{name}")
public class FiltersService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
		
		@GET
//		@Path("/filters/{name}")
		@Produces({MediaType.APPLICATION_JSON})
		public Filter getFilter(@PathParam("name") String name){
			Filter filter = DataProvider.getInstance().getFilterByName(name);
			System.out.println("################################# GET");
			if(null != filter){
				return filter;
			}
			return null;
		}
		
		@PUT
		@Produces(MediaType.TEXT_HTML)
		public void setFilter(@PathParam("name") String name, String jsontString) throws JsonParseException, JsonMappingException, IOException{
			System.out.println("################################# PUT");
			ObjectMapper mapper = DataProvider.getInstance().getMapper();
			Filter filter = mapper.readValue(jsontString, Filter.class);
			if(null == DataProvider.getInstance().setFilter(filter)){
				System.out.println("Something went wrong while persisting filter object");
			}
			System.out.println("FilterList:\n");
			System.out.println(DataProvider.getInstance().filterListToString());
		}
		
		@POST
		@Produces(MediaType.TEXT_HTML)
		public void updateFilter(@PathParam("name") String name, String jsonString) throws JsonParseException, JsonMappingException, IOException{
			System.out.println("################################# POST");
			ObjectMapper mapper = DataProvider.getInstance().getMapper();
			Filter newFilterObject = mapper.readValue(jsonString, Filter.class);
			Filter oldFilterObject = DataProvider.getInstance().getFilterByName(name);
			
			if (null != oldFilterObject) {
				oldFilterObject.setName(newFilterObject.getName());
				oldFilterObject.setBlue(newFilterObject.getBlue());
				oldFilterObject.setGreen(newFilterObject.getGreen());
				oldFilterObject.setRed(newFilterObject.getRed());
				oldFilterObject.setBrightness(newFilterObject.getBrightness());
				oldFilterObject.setSaturation(newFilterObject.getSaturation());
				oldFilterObject.setContrast(newFilterObject.getContrast());
				oldFilterObject.setNegative(newFilterObject.isNegative());
				System.out.println("oldfilterObject: "+oldFilterObject.toString());
			}else{
				System.out.println("Something went wrong during filter object update process");
				
			}
			System.out.println(DataProvider.getInstance().filterListToString());
		}
		
		@DELETE
		@Produces(MediaType.TEXT_HTML)
		public void deleteFilter(@PathParam("name") String name){
			System.out.println("################################# DELETE");
			DataProvider.getInstance().removeFilter(name);
			System.out.println("FilterList:\n");
			System.out.println(DataProvider.getInstance().filterListToString());
		}
}
