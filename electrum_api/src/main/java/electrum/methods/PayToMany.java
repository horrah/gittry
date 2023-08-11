package electrum.methods;


import java.io.IOException;
import java.io.InputStream;

import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.request.ParamPayToMany;
import electrum.request.ParamPayToManyWithPassword;
import electrum.response.JsonRPCresponse;
import electrum.response.Output;

public class PayToMany {

	public String payToMany(String[][] outputs) {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		int feerate = new GetFeeRate().getFeeRate();
		String tx;
		String transaction = null;
		
		ParamPayToMany paramPayToMany = new ParamPayToMany();
		paramPayToMany.setOutputs(outputs);
		paramPayToMany.setFeerate(feerate);
		//paramPayToMany.setPassword(password);
		try {
			json = createRequestBody.create("paytomany", paramPayToMany);
			//System.out.println(json);
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			//System.out.println(text);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, String.class);
			JsonRPCresponse<String> jsonRPCresponsePayTo = objectMapper.readValue(input, javaType);
			tx = jsonRPCresponsePayTo.getResult();
			//System.out.println(tx);
			
			Output[] outputsDeserialized = new Deserialize().deserialize(tx);
			boolean flag = true;
			int amount_sats;
			String address;
			boolean[] flags = new boolean[outputs.length];
			for(int i = 0; i < outputs.length; i++) {
				address = outputs[i][0];
				amount_sats = (int)Math.round(Double.parseDouble(outputs[i][1]) * 100000000);
				//System.out.println(address+"  "+amount_sats);
				for(Output output : outputsDeserialized) {
					//if(outputsDeserialized[i])
					if(address.equals(output.getAddress())) {
						if(amount_sats == output.getValue_sats()) {
							flags[i]=true;
							break;
						}
					}
				}
			}
			for(boolean f : flags) {
				if(!f) {
					flag=false; break;
				}
			}
			if(flag) 
				transaction = new Broadcast().broadcast(tx);
			TimeUnit.SECONDS.sleep(6);
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
	
	public String payToMany(String[][] outputs, String password) {
		String json;
		InputStream input; 
		JavaType javaType;
		ObjectMapper objectMapper = new ObjectMapper();
		CreateRequestBody createRequestBody = new CreateRequestBody();
		int feerate = new GetFeeRate().getFeeRate();
		String tx;
		String transaction = null;
		
		ParamPayToManyWithPassword paramPayToMany = new ParamPayToManyWithPassword();
		paramPayToMany.setOutputs(outputs);
		paramPayToMany.setFeerate(feerate);
		paramPayToMany.setPassword(password);
		try {
			json = createRequestBody.create("paytomany", paramPayToMany);
			//System.out.println(json);
			input = new SendRequest().send(json);
			//String text = new String(input.readAllBytes(), StandardCharsets.UTF_8);
			//System.out.println(text);
			javaType = objectMapper.getTypeFactory().constructParametricType(JsonRPCresponse.class, String.class);
			JsonRPCresponse<String> jsonRPCresponsePayTo = objectMapper.readValue(input, javaType);
			tx = jsonRPCresponsePayTo.getResult();
			//System.out.println(tx);
			
			Output[] outputsDeserialized = new Deserialize().deserialize(tx);
			boolean flag = true;
			int amount_sats;
			String address;
			boolean[] flags = new boolean[outputs.length];
			for(int i = 0; i < outputs.length; i++) {
				address = outputs[i][0];
				amount_sats = (int)Math.round(Double.parseDouble(outputs[i][1]) * 100000000);
				//System.out.println(address+"  "+amount_sats);
				for(Output output : outputsDeserialized) {
					//if(outputsDeserialized[i])
					if(address.equals(output.getAddress())) {
						if(amount_sats == output.getValue_sats()) {
							flags[i]=true;
							break;
						}
					}
				}
			}
			for(boolean f : flags) {
				if(!f) {
					flag=false; break;
				}
			}
			if(flag) 
				transaction = new Broadcast().broadcast(tx);
			TimeUnit.SECONDS.sleep(6);
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
