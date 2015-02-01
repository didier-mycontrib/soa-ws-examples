package client;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class DevisesClientRestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test du web service rest via org.apache.httpcomponents/httpclient
		// NB: code volontairement pas factorisé avec sous méthodes communes pour bien montrer
		// l'utilisation de l'api httpclient (apache)
		testCreateNewDevise("monnaie_xyz","1.123");
		testAllDevises();
		testUpdateDevise("monnaie_xyz","1.002");
		testDeviseByName("monnaie_xyz");
		testDeleteDevise("monnaie_xyz");
	}
	public static void testAllDevises() {		
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/devises/allJson");
		    //.setPath(restAppPart + "/devises/all");
		URI uri = builder.build();
		String urlAllDevises=uri.toString();
		System.out.println("HTTP/REST GET URL="+urlAllDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(urlAllDevises);
		HttpResponse response = httpclient.execute(httpget);
			
		String resXmlStringAllDevises=EntityUtils.toString(response.getEntity());			
		System.out.println("devises:"+resXmlStringAllDevises);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testDeviseByName(String name) {		
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/devises/byName/" + name);
		URI uri = builder.build();
		String urlAllDevises=uri.toString();
		System.out.println("HTTP/REST GET URL="+urlAllDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(urlAllDevises);
		HttpResponse response = httpclient.execute(httpget);
			
		String resXmlStringAllDevises=EntityUtils.toString(response.getEntity());			
		System.out.println("devise:"+resXmlStringAllDevises);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testCreateNewDevise(String name,String change) {
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/devises/create");
		URI uri = builder.build();
		String urlCreateDevises=uri.toString();
		System.out.println("HTTP/REST POST URL="+urlCreateDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost(urlCreateDevises);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("name", name));
		formparams.add(new BasicNameValuePair("change", change));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");		
		httppost.setEntity(entity);
		
		HttpResponse response = httpclient.execute(httppost);			
		System.out.println("response:"+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testUpdateDevise(String name,String change) {
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/devises/update");
		URI uri = builder.build();
		String urlUpdateDevises=uri.toString();
		System.out.println("HTTP/REST PUT URL="+urlUpdateDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPut httpput = new HttpPut(urlUpdateDevises);
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("name", name));
		formparams.add(new BasicNameValuePair("change", change));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");		
		httpput.setEntity(entity);
		
		HttpResponse response = httpclient.execute(httpput);			
		System.out.println("response:"+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testDeleteDevise(String name) {
		try {
		String restAppPart = "/wsCalculateur/services/rest";
		URIBuilder builder = new URIBuilder();
		builder.setScheme("http").setHost("localhost").setPort(8080)
		    .setPath(restAppPart + "/devises/delete/" + name);
		   
		URI uri = builder.build();
		String urlDeleteDevises=uri.toString();
		System.out.println("HTTP/REST DELETE URL="+urlDeleteDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpDelete httpdelete = new HttpDelete(urlDeleteDevises);
		
		HttpResponse response = httpclient.execute(httpdelete);			
		System.out.println("response:"+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
