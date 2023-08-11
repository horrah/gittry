package electrum.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summary {
	Status begin;
	Status end;
	Flow_in_out flow;
	
	public Status getBegin() {
		return begin;
	}
	public void setBegin(Status begin) {
		this.begin = begin;
	}
	public Status getEnd() {
		return end;
	}
	public void setEnd(Status end) {
		this.end = end;
	}
	public Flow_in_out getFlow() {
		return flow;
	}
	public void setFlow(Flow_in_out flow) {
		this.flow = flow;
	}	
}
