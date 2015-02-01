package client.cxf;

import generic.ws.util.client.cxf.CxfJaxWsClientPropertiesUtil;
import tp.service.Calculateur;
import tp.service.CalculateurImplService;

public class WssSecureCalculateurClientSoapWithCxfApp {
	
public static void main(String[] args) {
	//code qui s'appuie sur le résultat  de wsimport du jdk >= 1.6
	//(src/script/lancerWsImport.sh depuis linux + Refresh eclipse)
	try {		
		CalculateurImplService calculateurSoapService = new CalculateurImplService();
	    Calculateur calculateur = calculateurSoapService.getCalculateurImplPort();
	    
	    CxfJaxWsClientPropertiesUtil jaxWsClientPropertiesUtil = new CxfJaxWsClientPropertiesUtil("wssCalculateur.properties");
	    jaxWsClientPropertiesUtil.setWssAuthFromProperties(calculateur);
	    jaxWsClientPropertiesUtil.setEndpointUrlFromProperties(calculateur);

	
	System.out.println("3+5="+calculateur.addition(3, 5));
	System.out.println("Auteur="+calculateur.getAuteur());
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
