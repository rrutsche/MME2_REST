package util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import service.DataProvider;
import domain.FilterDto;

public class JSONConverter {
	
	static ObjectMapper mapper = DataProvider.getInstance().getMapper();
	
	public static String filterDtoToJson(FilterDto dto) throws JsonGenerationException, JsonMappingException, IOException{
		return mapper.writeValueAsString(dto);
	}
	
	public static FilterDto jsonToFilterDto(String jsonString) throws JsonParseException, JsonMappingException, IOException{
		FilterDto filter = mapper.readValue(jsonString, FilterDto.class);
		return filter;
	}
	
}
