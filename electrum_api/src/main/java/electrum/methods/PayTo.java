package electrum.methods;

import java.io.IOException;
import java.io.InputStream;

import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.ParamPayTo;
import electrum.request.ParamPayToWithPassword;
import electrum.response.JsonRPCresponse;
import electrum.response.Output;

public class PayTo {

	public String payTo(String address, Double amount) {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		int feerate = new GetFeeRate().getFeeRate();
		String tx;
		String transaction=null;
		
		ParamPayTo paramPayTo = new ParamPayTo();
		paramPayTo.setAmount(amount);
		paramPayTo.setDestination(address);
		paramPayTo.setFeerate(feerate);
		//paramPayTo.setPassword(password);
		try {
			json = createRequestBody.create("payto", paramPayTo);
			//System.out.println(json);
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			//System.out.println(text);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, String.class);
			JsonRPCresponse<String> jsonRPCresponsePayTo = objectMapper.readValue(input, javaType);
			tx = jsonRPCresponsePayTo.getResult();
			//System.out.println(tx);
			
			boolean flag = false;
			int amount_sats = (int)Math.round(amount * 100000000);
			Output[] outputs = new Deserialize().deserialize(tx);
			for(Output output : outputs) {
				if(output.getAddress().equals(address)) {
					if(output.getValue_sats()==amount_sats)
						flag=true;
				}
				
			}
			
			if(flag) 
				transaction = new Broadcast().broadcast(tx);
			TimeUnit.SECONDS.sleep(10);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
	
	public String payTo(String address, Double amount, String password) {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		int feerate = new GetFeeRate().getFeeRate();
		String tx;
		String transaction=null;
		
		ParamPayToWithPassword paramPayTo = new ParamPayToWithPassword();
		paramPayTo.setAmount(amount);
		paramPayTo.setDestination(address);
		paramPayTo.setFeerate(feerate);
		paramPayTo.setPassword(password);
		try {
			json = createRequestBody.create("payto", paramPayTo);
			//System.out.println(json);
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			//System.out.println(text);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, String.class);
			JsonRPCresponse<String> jsonRPCresponsePayTo = objectMapper.readValue(input, javaType);
			tx = jsonRPCresponsePayTo.getResult();
			//System.out.println(tx);
			
			boolean flag = false;
			int amount_sats = (int)Math.round(amount * 100000000);
			Output[] outputs = new Deserialize().deserialize(tx);
			for(Output output : outputs) {
				if(output.getAddress().equals(address)) {
					if(output.getValue_sats()==amount_sats)
						flag=true;
				}
				
			}
			
			if(flag) 
				transaction = new Broadcast().broadcast(tx);
			TimeUnit.SECONDS.sleep(10);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return transaction;
	}
}
