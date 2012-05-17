package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/filters")
public class FiltersService {
	
	// This method is called if XML is request
		@GET
		@Produces(MediaType.TEXT_XML)
		public String sayXMLHello() {
			return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
		}
	
}
