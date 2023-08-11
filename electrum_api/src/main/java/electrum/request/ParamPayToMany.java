package electrum.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParamPayToMany {
	String[][] outputs;
	Integer feerate;
	@JsonIgnore
	String password;
	
	public ParamPayToMany() {}

	public ParamPayToMany(String[][] outputs, Integer feerate, String password) {
		this.outputs = outputs;
		this.feerate = feerate;
		this.password = password;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getFeerate() {
		return feerate;
	}

	public void setFeerate(Integer feerate) {
		this.feerate = feerate;
	}

	public String[][] getOutputs() {
		return outputs;
	}

	public void setOutputs(String[][] outputs) {
		this.outputs = outputs;
	}
	
}
