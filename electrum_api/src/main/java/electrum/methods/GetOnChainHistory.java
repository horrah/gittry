package electrum.methods;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.ParamOnchainHistory;
import electrum.response.JsonRPCresponse;
import electrum.response.Result;

public class GetOnChainHistory {
	public Result getResult(){
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		JsonRPCresponse<Result> jsonRPCresponse = null;
		try {
			json = createRequestBody.create("onchain_history", new ParamOnchainHistory(true));
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, Result.class);
			jsonRPCresponse = objectMapper.readValue(input, javaType);
			//Result result = jsonRPCresponseOnchain.getResult();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonRPCresponse.getResult();
	}
}
