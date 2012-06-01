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
import domain.FilterListSuccess;
import domain.FilterSuccess;

@Path("/filters")
public class FiltersService {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getFilter(@PathParam("id") long id)
			throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("################################# GET");

		Filter filter = DataProvider.getInstance().getFilterById(id);
		FilterSuccess message = new FilterSuccess();
		if (filter != null) {
			message.setSuccess(true).setMessage("").setFilter(filter);
			return JSONConverter.filterToJson(message);
		} else {
			message.setSuccess(false).setMessage("filter not found")
					.setFilter(filter);
			return JSONConverter.filterToJson(message);
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public String getFilters() throws JsonGenerationException,
			JsonMappingException, IOException {
		System.out.println("################################# GET");

		Filter[] filters = DataProvider.getInstance().getAllFilters();
		FilterListSuccess message = new FilterListSuccess();

		if (filters.length > 0) {
			message.setSuccess(true).setMessage("").setFilters(filters);
			return JSONConverter.filterArrayToJson(message);
		} else {
			message.setSuccess(false).setMessage("no filters")
					.setFilters(filters);
			return JSONConverter.filterArrayToJson(message);
		}
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String setFilter(@PathParam("name") String name, String jsonString)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("################################# PUT");

		boolean success = DataProvider.getInstance().setFilter(
				JSONConverter.jsonToFilter(jsonString));
		FilterSuccess message = new FilterSuccess();

		if (success) {
			message.setSuccess(true).setMessage("new filter created")
					.setFilter(JSONConverter.jsonToFilter(jsonString));
			return JSONConverter.filterToJson(message);
		} else {
			message.setSuccess(false).setMessage("filter could not be created")
					.setFilter(JSONConverter.jsonToFilter(jsonString));
			return JSONConverter.filterToJson(message);
		}

	}

	@POST
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String updateFilter(@PathParam("id") long id, String jsonString)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("################################# POST");

		boolean success = DataProvider.getInstance().updateFilter(
				JSONConverter.jsonToFilter(jsonString));
		FilterSuccess message = new FilterSuccess();

		if (success) {
			message.setSuccess(true).setMessage("filter updated")
					.setFilter(JSONConverter.jsonToFilter(jsonString));
			return JSONConverter.filterToJson(message);
		} else {
			message.setSuccess(false).setMessage("filter could not be updated")
					.setFilter(JSONConverter.jsonToFilter(jsonString));
			return JSONConverter.filterToJson(message);
		}

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public String deleteFilter(@PathParam("id") long id) throws JsonGenerationException, JsonMappingException, IOException {
		System.out.println("################################# DELETE");

		boolean success = DataProvider.getInstance().removeFilter(id);
		FilterSuccess message = new FilterSuccess();

		if (success) {
			message.setSuccess(true).setMessage("filter deleted");
			return JSONConverter.filterToJson(message);
		} else {
			message.setSuccess(false).setMessage("filter could not be updated");
			return JSONConverter.filterToJson(message);
		}
	}
}
