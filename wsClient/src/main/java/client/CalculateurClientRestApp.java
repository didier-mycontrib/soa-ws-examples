package client;

import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class CalculateurClientRestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test du web service rest via org.apache.httpcomponents/httpclient
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/calculateur/addition")
		    .setParameter("a", "5")
		    .setParameter("b", "6");
		URI uri = builder.build();
		String url5plus6=uri.toString();
		System.out.println("REST GET URL="+url5plus6);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url5plus6);
		HttpResponse response = httpclient.execute(httpget);
			
		String res5plus6=EntityUtils.toString(response.getEntity());			
		System.out.println("5+6="+res5plus6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
