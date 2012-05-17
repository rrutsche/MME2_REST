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


import com.sun.jersey.json.impl.writer.JsonEncoder;

import domain.Filter;

@Path("/filters/{name}")
public class FiltersService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
	
	
		
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		public Filter getFilter(@PathParam("name") String name){
			Filter filter = DataProvider.getInstance().getFilterByName(name);
			System.out.println("################################# GET");
			if(null != filter){
				return filter;
			}
			return null;
		}
		
		@POST
		@Produces(MediaType.TEXT_HTML)
//		@Consumes({MediaType.APPLICATION_JSON})
		public void setFilter(String name) throws JsonParseException, JsonMappingException, IOException{
			System.out.println("################################# POST");
			ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
			Filter filter = mapper.readValue(name, Filter.class);
			System.out.println(filter.toString());
		}
		
		@PUT
		@Produces(MediaType.TEXT_HTML)
		@Consumes({MediaType.APPLICATION_JSON})
		public void updateFilter(){
			System.out.println("################################# PUT");
		}
		
		@DELETE
		@Produces(MediaType.TEXT_HTML)
		public void deleteFilter(){
			
		}
}
