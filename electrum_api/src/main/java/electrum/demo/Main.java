package electrum.demo;



import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import electrum.methods.Deserialize;
import electrum.methods.GetFeeRate;
import electrum.methods.GetOnChainHistory;
import electrum.methods.ListAddresses;
import electrum.methods.PayTo;
import electrum.methods.PayToMany;
import electrum.response.Output;
import electrum.response.Result;
import electrum.response.Transaction;


public class Main {

	public static void main(String[] args)  {
		ObjectMapper objectMapper = new ObjectMapper();
		
		int feerate = new GetFeeRate().getFeeRate();
		System.out.println("feerate = "+ feerate);
		

		Result result = new GetOnChainHistory().getResult();
		System.out.println("wallet balance = "+result.getSummary().getBegin().getBTC_balance()+" date = "+result.getSummary().getBegin().getDate());
		System.out.println("wallet balance = "+result.getSummary().getEnd().getBTC_balance()+" date = "+result.getSummary().getEnd().getDate());
		System.out.println("btc_incoming = "+result.getSummary().getFlow().getbTC_incoming());
		Transaction[] transactions = result.getTransactions();
		for(Transaction transaction : transactions) {
			System.out.println("bc_value = "+transaction.getBc_value());
			System.out.println("incoming = "+transaction.getIncoming());
			System.out.println("conformations = "+transaction.getConfirmations());
			System.out.println("txid = "+transaction.getTxid());
			for(Output output : transaction.getOutputs()) {
				System.out.println("address = " + output.getAddress());
			}
			System.out.println("Bc_value = "+transaction.getBc_value());
		}
		Output[] outputs = new Deserialize().deserialize("0200000000010126a65160de2bcc1e46308209670ed320ff23550fdb31b96a661608ede6a49d000000000000fdffffff02ac260000000000001600140ab8ce8b4c63186710c90ed4cbb14f64fecac7e310270000000000001600144fda16bb1c1d870875f54b27d705c03f89f92d4702473044022067ff1cccfaec698aeb81b74c9ff5872a4769e2e705865ad1dcbee78ce37e8cea02202c194a4d5b4e54f396c5482523fe001e31acbd75e966c4b4d29cd931df6c155a0121025ad75aac47e461cfebc26e2d3d1a53d90cc4f48556e1a89ceda06206f61a6d44493e2500");
		for(Output output : outputs) {
			System.out.println("address = " + output.getAddress());
			//System.out.println("value_sats = " + output.getValue_sats());
		}
		
		String txid;
		String[][] outputs1 = {{"tb1qq43jsy5q46sf3wljg8l7luqrjwjczeqhywjjfj", "0.0008"}, {"tb1qzs6fq7j9wn4x4w9daruvke5793fkw4yty03u5f", "0.0009"}, {"tb1q3pctvpvyzm799zmtw894achdxdw0l86zpcceu2", "0.0006"}};
		
		txid = new PayToMany().payToMany(outputs1);
		txid = new PayToMany().payToMany(outputs1);
		System.out.println(txid);
		
		txid = new PayTo().payTo("tb1qy8y23vgyzkgq438l4xpy0kp6dscp0yvkxt224l", 0.0001);
		
		System.out.println(txid);
		
		String[] strings = new ListAddresses().listAddresses();
		System.out.println(Arrays.toString(strings));
		
		
		try {
			System.out.println(objectMapper.writeValueAsString(transactions[0].getOutputs()));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
