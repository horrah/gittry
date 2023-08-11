package electrum.request;

public class ParamBroadcast {
	String tx;

	public ParamBroadcast() {}

	public ParamBroadcast(String tx) {
		this.tx = tx;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}
	
}
