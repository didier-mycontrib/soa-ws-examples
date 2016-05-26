package tp.testwsa.client;


import javax.jws.Oneway; 
import javax.jws.WebParam; 
import javax.jws.WebService; 
import javax.xml.ws.RequestWrapper; 

@WebService() 
public interface Callback { 

	String NS = "hello.wsatest.service.tp"; 
  
	@Oneway 
 @RequestWrapper(localName="sayHelloResponse", targetNamespace=NS) 
 public void callBack(@WebParam(name="response") String callbackMessage); 
 } 

