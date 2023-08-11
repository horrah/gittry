package electrum.response;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)

public class Transaction {
    //Double bc_balance;
    Double bc_value;
    Integer confirmations;
    LocalDateTime date;
    Double fee;
    Integer fee_sat;
    Integer height;
    Boolean incoming;
    String label;
    Long monotonic_timestamp;
    Long timestamp;
    String txid;
    Short txpos_in_block;
    Output[] outputs;

    
    
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Integer getFee_sat() {
		return fee_sat;
	}
	public void setFee_sat(Integer fee_sat) {
		this.fee_sat = fee_sat;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Long getMonotonic_timestamp() {
		return monotonic_timestamp;
	}
	public void setMonotonic_timestamp(Long monotonic_timestamp) {
		this.monotonic_timestamp = monotonic_timestamp;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Short getTxpos_in_block() {
		return txpos_in_block;
	}
	public void setTxpos_in_block(Short txpos_in_block) {
		this.txpos_in_block = txpos_in_block;
	}
	public void setBc_value(Double bc_value) {
		this.bc_value = bc_value;
	}
	public Boolean getIncoming() {
		return incoming;
	}
	public void setIncoming(Boolean incoming) {
		this.incoming = incoming;
	}
	public Output[] getOutputs() {
		return outputs;
	}
	public void setOutputs(Output[] outputs) {
		this.outputs = outputs;
	}

	public Double getBc_value() {
		return bc_value;
	}
	public void setBc_value(String bc_value) {
		this.bc_value = Double.parseDouble(bc_value);
	}
	public Integer getConfirmations() {
		return confirmations;
	}
	public void setConfirmations(Integer confirmations) {
		this.confirmations = confirmations;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(String date) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.date = LocalDateTime.parse(date, formatter1);;
	}
	public String getTxid() {
		return txid;
	}
	public void setTxid(String txid) {
		this.txid = txid;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
}
