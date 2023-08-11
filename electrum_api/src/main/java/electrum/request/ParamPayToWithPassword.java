package electrum.request;

//import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParamPayToWithPassword {
	String destination;
	Double amount;
	Integer feerate;
	//@JsonIgnore
	String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getFeerate() {
		return feerate;
	}
	public void setFeerate(Integer feerate) {
		this.feerate = feerate;
	}
	
	
	
}
