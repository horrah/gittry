package electrum.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
	 
	Summary summary;
	Transaction[] transactions;
	Output[] outputs;
	
	public Result() {}
	
	public Output[] getOutputs() {
		return outputs;
	}

	public void setOutputs(Output[] outputs) {
		this.outputs = outputs;
	}

	public Summary getSummary() {
		return summary;
	}
	public void setSummary(Summary summary) {
		this.summary = summary;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public void setTransactions(Transaction[] transactions) {
		this.transactions = transactions;
	}
	
	
}
