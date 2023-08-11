package electrum.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ParamOnchainHistory {
	
	@JsonIgnore
	LocalDate year;
	Boolean show_addresses = false;
	//@JsonIgnore
	Integer from_height=0;
	//@JsonIgnore
	Integer to_height=Integer.MAX_VALUE;

	
	
	public ParamOnchainHistory() {	}
	
	
	
	public ParamOnchainHistory(Boolean show_addresses) {
		super();
		this.show_addresses = show_addresses;
	}


	

	public ParamOnchainHistory(Boolean show_addresses, Integer from_height, Integer to_height) {
		super();
		this.show_addresses = show_addresses;
		this.from_height = from_height;
		this.to_height = to_height;
	}



	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public Boolean getShow_addresses() {
		return show_addresses;
	}
	public void setShow_addresses(Boolean show_addresses) {
		this.show_addresses = show_addresses;
	}
	public Integer getFrom_height() {
		return from_height;
	}
	public void setFrom_height(Integer from_height) {
		this.from_height = from_height;
	}
	public Integer getTo_height() {
		return to_height;
	}
	public void setTo_height(Integer to_height) {
		this.to_height = to_height;
	}
	
	
}
