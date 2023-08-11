package electrum.request;

public class ParamListAddresses {

	Boolean receiving;
	Boolean unused;
	
	public ParamListAddresses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParamListAddresses(Boolean receiving, Boolean unused) {
		super();
		this.receiving = receiving;
		this.unused = unused;
	}
	public Boolean getReceiving() {
		return receiving;
	}
	public void setReceiving(Boolean receiving) {
		this.receiving = receiving;
	}
	public Boolean getUnused() {
		return unused;
	}
	public void setUnused(Boolean unused) {
		this.unused = unused;
	}
	
}
