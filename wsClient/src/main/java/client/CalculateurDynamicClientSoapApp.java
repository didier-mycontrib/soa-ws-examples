package client;

import generic.ws.util.client.DynReflectSoapClient;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import tp.service.Calculateur;

/*
 * cette version "dynamic" du client soap ne s'appuie que sur l'inteface java du web service à invoquer
 * et la description WSDL (généralement au bout d'une URL http en ?wsdl) n'est utile qu'au moment de la programmation
 * et n'est plus nécessaire lors de l'exécution du code (contrairement à la version "statique" entièrement basée sur wsimport)
 * 
 * NB: l'implementation (par defaut) de service.getPort(PORT_NAME, Xxxx.class); fournie par le jdk >=1.6
 * ne permet pas de faire fonctionner ce code (implémentation limitée !!!)
 * 
 * Le code de cette classe ne fonctionne correctement qu'avec les ".jar" de la technologie cxf
 * et l'implémentation améliorée de service.getPort(PORT_NAME, Xxxx.class); fournie par CXF .
 * 
 * VIVE CXF (quelquefois également utile coté client) !!!
 */

public class CalculateurDynamicClientSoapApp {
	
	public static Calculateur initProxy(){
		
		//NB: les informations SERVICE_NAME et PORT_NAME se trouvent dans le fichier WSDL qui décrit le service web
		//et elles sont sencées être stables
		QName SERVICE_NAME = new QName("http://service.tp/", "CalculateurImplService");
		QName PORT_NAME = new QName("http://service.tp/", "CalculateurImplPort");
		Service service = Service.create(SERVICE_NAME);		//javax.xml.ws.Service
		// Endpoint Address (variant souvent : dev , recette , prod , ...)
		String proxyWsUrl = "http://localhost:8080/wsCalculateur/services/calculateur";
		// Add a port to the Service , javax.xml.ws.soap.SOAPBinding
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,proxyWsUrl);

		//NB: l'interface java "Calculateur" doit absolument comporter les annotations @WebService (et @WebParam)
		// celle ci peut être récupérer par copie de code (depuis le projet serveur s'il est en java)
		// ou bien peut être initialement générée via wsimport et le fichier WSDL
		Calculateur calcProxy = (Calculateur) service.getPort(PORT_NAME, Calculateur.class);
		return calcProxy;
}

	
public static void main(String[] args) {
	//code qui ne s'appuie sur l'interface "Calculateur" générée par wsimport du jdk >= 1.6
	//ou bien par copie de Code (copie de l'interface)
	try {
		
	Calculateur calculateur = initProxy();
	
	System.out.println("3+5="+calculateur.addition(3, 5));
	System.out.println("Auteur="+calculateur.getAuteur());
	
	
	// test2 (via generic.ws.util.client.DynReflectSoapClient)
	
	DynReflectSoapClient dynSoapClient = new DynReflectSoapClient();
	String wsUrl="http://localhost:8080/wsCalculateur/services/calculateur";
	System.out.println("dynSoapCall result(3+5)="+
	dynSoapClient.dynSoapCall(wsUrl,"tp.service.Calculateur","addition",  new Double(3),new Double(5)));
	System.out.println("dynSoapCall result(4*6)="+
	dynSoapClient.dynSoapCall(wsUrl,"tp.service.Calculateur","multiplication",  new Double(4),new Double(6)));
	System.out.println("dynSoapCall result(getAuteur)="+
	dynSoapClient.dynSoapCall(wsUrl,"tp.service.Calculateur","getAuteur"));
	
	// test3 (mixte : DynReflectSoapClient pour recupérer proxy):
	Calculateur dynCalculateur = (Calculateur) dynSoapClient.getWsProxy(wsUrl, Calculateur.class);
	System.out.println("3+5 (avec dynSoapClient.getWsProxy)="+dynCalculateur.addition(3, 5));
	
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
