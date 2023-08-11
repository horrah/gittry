package electrum.methods;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.ParamDeserialize;
import electrum.response.JsonRPCresponse;
import electrum.response.Output;
import electrum.response.Result;

public class Deserialize {
	public Output[] deserialize(String tx) {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		JsonRPCresponse<Result> jsonRPCresponseDeserialize = null;
		Result result = null;
		System.out.println(tx);
		try {
			json = createRequestBody.create("deserialize", new ParamDeserialize(tx));
			System.out.println(json);
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			//System.out.println(text);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, Result.class);
			jsonRPCresponseDeserialize = objectMapper.readValue(input, javaType);
			result = jsonRPCresponseDeserialize.getResult();
			/*for(Output output : result.getOutputs()) {
				System.out.println("address = " + output.getAddress());
				System.out.println("value_sats = " + output.getValue_sats());
			}*/
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result.getOutputs();
	}
}
