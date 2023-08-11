package electrum.methods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.BodyOfRequest;

public class CreateRequestBody {
	public <T> String create(String method, T params) {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(new BodyOfRequest<T>(method, params));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(json);
		return json;
	}
	
}
