package electrum.request;

public class ParamDeserialize {
	String tx;

	
	
	public ParamDeserialize() {}

	public ParamDeserialize(String tx) {
		this.tx = tx;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}
	
}
