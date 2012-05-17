package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import domain.Filter;

@Path("/filters/{name}")
public class FiltersService {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;
		
		@GET
		@Produces({MediaType.APPLICATION_JSON})
		public String getFilter(@PathParam("name") String name){
			Filter filter = DataProvider.getInstance().getFilterByName(name);
			if(null != filter){
				return filter.toString();
			}
			return null;
		}
}
