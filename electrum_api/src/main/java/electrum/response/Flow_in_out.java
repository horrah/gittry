package electrum.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class Flow_in_out {
	@JsonSetter("BTC_incoming")
	Double bTC_incoming;
	@JsonSetter("BTC_outgoing")
    Double bTC_outgoing;
	public Double getbTC_incoming() {
		return bTC_incoming;
	}
	public void setbTC_incoming(String BTC_incoming) {
		this.bTC_incoming = Double.parseDouble(BTC_incoming);
	}
	public Double getBTC_outgoing() {
		return bTC_outgoing;
	}
	public void setBTC_outgoing(String BTC_outgoing) {
		this.bTC_outgoing = Double.parseDouble(BTC_outgoing);
	}
    
    
}
