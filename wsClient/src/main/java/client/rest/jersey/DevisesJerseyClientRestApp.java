package client.rest.jersey;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DevisesJerseyClientRestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		testCreateNewDevise("monnaie_xyz","1.123");
		testAllDevises();
		testUpdateDevise("monnaie_xyz","1.002");
		testDeviseByName("monnaie_xyz");
		testDeleteDevise("monnaie_xyz");
		
	}
	
	private static WebResource buildWebResource(String resourceUrl){	
		Client client = Client.create();
		WebResource webResource = client.resource(resourceUrl);
		return webResource;
	}
				
	
	private static void processjJerseyResponse(ClientResponse response){
		try {
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Output from Server : ");
			System.out.println(output+"\n");

		  } catch (Exception e) {
			e.printStackTrace();
		  }
	}
	
	public static void testAllDevises(){
			System.out.println("devises/allJson : ");
			WebResource webResource = buildWebResource("http://localhost:8080/wsCalculateur/services/rest/devises/allJson");
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			processjJerseyResponse(response);
		}
	
	public static void testDeviseByName(String name) {
		System.out.println("devises/byName (GET):");
		WebResource webResource = buildWebResource("http://localhost:8080/wsCalculateur/services/rest/devises/byNameJson/" + name);
			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);
			processjJerseyResponse(response);
	}
	
	
	
	public static void testCreateNewDevise(String name,String change) {
		WebResource webResource = buildWebResource("http://localhost:8080/wsCalculateur/services/rest/devises/createFromJson" );
			String input = "{\"name\":\"" + name + "\",\"change\":" + change + " }";
			System.out.println("devises/createFromJson (POST) , input=" + input);
			ClientResponse response = webResource.type("application/json")
	                   .post(ClientResponse.class,input);
			processjJerseyResponse(response);
	}
	
	public static void testUpdateDevise(String name,String change) {
		WebResource webResource = buildWebResource("http://localhost:8080/wsCalculateur/services/rest/devises/updateFromJson" );
			String input = "{\"name\":\"" + name + "\",\"change\":" + change + " }";
			System.out.println("devises/updateFromJson (PUT) , input=" + input);
			ClientResponse response = webResource.type("application/json")
	                   .put(ClientResponse.class,input);
			processjJerseyResponse(response);
	}
	
	public static void testDeleteDevise(String name) {
		System.out.println("devises/delete (DELETE) :");
		WebResource webResource = buildWebResource("http://localhost:8080/wsCalculateur/services/rest/devises/delete/"+name );
		ClientResponse response = webResource.delete(ClientResponse.class);
		processjJerseyResponse(response);
	}

}
