package client.rest.via_http_client;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
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
import org.apache.http.client.methods.HttpUriRequest;
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
	
	private static String buildURL(String endOfURL){
		String url=null;
		try {
			String restAppPart = "/wsCalculateur/services/rest";
			URIBuilder builder = new URIBuilder();
			builder.setScheme("http").setHost("localhost").setPort(8080)
			    .setPath(restAppPart + endOfURL);
			URI uri = builder.build();
			url=uri.toString();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	private static UrlEncodedFormEntity getUrlEncodedFormEntity(String name, String change){
		UrlEncodedFormEntity entity = null;
		try {
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("name", name));
			formparams.add(new BasicNameValuePair("change", change));
			entity = new UrlEncodedFormEntity(formparams, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return entity;
	}
	
	private static void executeAndDisplayResponse(HttpUriRequest httpUriRequest){
		try{
		//httpUriRequest = httpGet ou httpPost ou ...
		HttpClient httpclient =  new DefaultHttpClient();
		HttpResponse response = httpclient.execute(httpUriRequest);			
		System.out.println("response:"+response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testAllDevises() {		
		try {
		String urlAllDevises=buildURL("/devises/allJson");
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
		String urlGetDevises=buildURL("/devises/byName/" + name);
		System.out.println("HTTP/REST GET URL="+urlGetDevises);
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(urlGetDevises);
		HttpResponse response = httpclient.execute(httpget);
			
		String resXmlStringAllDevises=EntityUtils.toString(response.getEntity());			
		System.out.println("devise:"+resXmlStringAllDevises);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void testCreateNewDevise(String name,String change) {
		String urlCreateDevises=buildURL( "/devises/create");
		System.out.println("HTTP/REST POST URL="+urlCreateDevises);
		HttpPost httppost = new HttpPost(urlCreateDevises);
		UrlEncodedFormEntity entity = getUrlEncodedFormEntity(name,change);		
		httppost.setEntity(entity);
		executeAndDisplayResponse(httppost);
	}
	
	public static void testUpdateDevise(String name,String change) {
			String urlUpdateDevises=buildURL("/devises/update");
			System.out.println("HTTP/REST PUT URL="+urlUpdateDevises);
			HttpPut httpput = new HttpPut(urlUpdateDevises);
			UrlEncodedFormEntity entity = getUrlEncodedFormEntity(name,change);			
			httpput.setEntity(entity);
			executeAndDisplayResponse(httpput);
	}
	
	public static void testDeleteDevise(String name) {
		try {
		String urlDeleteDevises	= buildURL("/devises/delete/" + name);
		System.out.println("HTTP/REST DELETE URL="+urlDeleteDevises);
		HttpDelete httpdelete = new HttpDelete(urlDeleteDevises);
		executeAndDisplayResponse(httpdelete);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
