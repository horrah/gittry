package electrum.methods;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.ParamBroadcast;
import electrum.response.JsonRPCresponse;

public class Broadcast {
	public synchronized String broadcast(String tx) {
		
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		String transaction=null;
		
		try {
			json = createRequestBody.create("broadcast", new ParamBroadcast(tx));
			input = new SendRequest().send(json);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, String.class);
			JsonRPCresponse<String> jsonRPCresponseBroadcast = objectMapper.readValue(input, javaType);
			transaction = jsonRPCresponseBroadcast.getResult();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
}
