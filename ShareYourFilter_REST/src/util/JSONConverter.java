package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import service.DataProvider;
import domain.Filter;
import domain.FilterListSuccess;
import domain.FilterSuccess;

public class JSONConverter {

	static ObjectMapper mapper = DataProvider.getInstance().getMapper();

	public static String filterToJson(FilterSuccess message)
			throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(message);
	}

	public static String filterArrayToJson(FilterListSuccess message)
			throws JsonGenerationException, JsonMappingException, IOException {
		return mapper.writeValueAsString(message);
	}

	public static Filter jsonToFilter(String jsonString)
			throws JsonParseException, JsonMappingException, IOException {
		Filter filter = mapper.readValue(jsonString, Filter.class);
		return filter;
	}

}
