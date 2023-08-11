package electrum.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class Output {
	String address;
	Double value;
	Integer value_sats;
	
	public Output() {}
	
	public Output(String address, Double value) {
		
		this.address = address;
		this.value = value;
	}
	
	public Output(String address, Integer value_sats) {
		
		this.address = address;
		this.value_sats = value_sats;
	}

	
	
	public Integer getValue_sats() {
		return value_sats;
	}

	public void setValue_sats(Integer value_sats) {
		this.value_sats = value_sats;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = Double.parseDouble(value);
	}
	
}
