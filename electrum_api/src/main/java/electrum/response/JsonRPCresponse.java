package electrum.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//данная аннотация игнорирует те значения в json которые не соответствуют
//ни одному из свойств POJO
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonRPCresponse<E>  {
	E result;

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}
	
}
