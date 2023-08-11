package electrum.methods;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.response.JsonRPCresponse;

public class GetFeeRate {

	public int getFeeRate() {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		JsonRPCresponse<Integer> jsonRPCresponseFeerate = null;
		try {
			json = createRequestBody.create("getfeerate", new String[0]);
			input = new SendRequest().send(json);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, Integer.class);
			jsonRPCresponseFeerate = objectMapper.readValue(input, javaType);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return jsonRPCresponseFeerate.getResult();
	}
}
