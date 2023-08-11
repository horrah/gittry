package electrum.request;

public class BodyOfRequest <T> {

	String jsonrpc = "2.0";
	String id = "curltext";
	String method = "onchain_history";
	T params;
	
	


	public BodyOfRequest() {}
	
	
	
	
	public BodyOfRequest(String method) {
		super();
		this.method = method;
	}




	public BodyOfRequest(String method, T params) {
		super();
		this.method = method;
		this.params = params;
	}




	public BodyOfRequest(T params) {
		this.params = params;
	}


	public String getJsonrpc() {
		return jsonrpc;
	}
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public T getParams() {
		return params;
	}
	public void setParams(T params) {
		this.params = params;
	}
	
	
}


// {\"jsonrpc\":\"2.0\",\"id\":\"curltext\",\"method\":\"onchain_history\",\"params\":{\"show_addresses\":true}}