package electrum.methods;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.util.Base64;

public class SendRequest {
	
	public synchronized InputStream send(String json) {
		HttpClient client = HttpClient.newHttpClient();
	
		// replace to your rpcuser and rpcpassowrd
		String credentials = "user" + ":" + "t";
		String auth = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
		HttpRequest request = HttpRequest.newBuilder()
	    .uri(URI.create("http://127.0.0.1:7777"))
	    .POST(BodyPublishers.ofString(json))
	    .setHeader("Content-Type", "application/x-www-form-urlencoded")
	    .setHeader("Authorization", auth)
	    .build();
		
		HttpResponse<InputStream> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.body();
	}
}
