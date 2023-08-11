package electrum.response;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
	@JsonSetter("BTC_balance")
	Double bTC_balance;
	LocalDateTime date;
	
	
	public Double getBTC_balance() {
		return bTC_balance;
	}
	
	public void setBTC_balance(String BTC_balance) {
		this.bTC_balance = Double.parseDouble(BTC_balance);
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(String date) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.date = LocalDateTime.parse(date, formatter1);;
	}
}
