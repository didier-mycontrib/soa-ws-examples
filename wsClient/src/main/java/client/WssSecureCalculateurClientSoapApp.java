package client;

import generic.ws.util.client.JaxWsClientPropertiesUtil;
import tp.service.Calculateur;
import tp.service.CalculateurImplService;

public class WssSecureCalculateurClientSoapApp {
	
public static void main(String[] args) {
	//code qui s'appuie sur le résultat  de wsimport du jdk >= 1.6
	//(src/script/lancerWsImport.sh depuis linux + Refresh eclipse)
	try {
		JaxWsClientPropertiesUtil<CalculateurImplService> jaxWsClientPropertiesUtil 
		= new JaxWsClientPropertiesUtil<CalculateurImplService>("wssCalculateur.properties",CalculateurImplService.class);
		
		CalculateurImplService calculateurSoapService = jaxWsClientPropertiesUtil.getSoapService();
		
		jaxWsClientPropertiesUtil.setWssAuthFromProperties(calculateurSoapService);
		
	    Calculateur calculateur = calculateurSoapService.getCalculateurImplPort();
	    
	    jaxWsClientPropertiesUtil.setEndpointUrlFromProperties(calculateur);

	
	System.out.println("3+5="+calculateur.addition(3, 5));
	System.out.println("Auteur="+calculateur.getAuteur());
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
