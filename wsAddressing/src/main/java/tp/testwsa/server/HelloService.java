package tp.testwsa.server;


import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(targetNamespace=HelloService.NS) 
@Addressing(enabled=true, required=true) 
public interface HelloService {

String NS = "hello.wsatest.service.tp"; 

@WebResult(name="response") 
public abstract String sayHello(@WebParam(name="user")String user); 


} 

