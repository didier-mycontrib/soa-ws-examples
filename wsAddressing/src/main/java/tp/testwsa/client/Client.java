package tp.testwsa.client;

import static org.apache.cxf.ws.addressing.JAXWSAConstants.CLIENT_ADDRESSING_PROPERTIES;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.jaxws.EndpointImpl;
//import org.apache.cxf.ws.addressing.AddressingPropertiesImpl; //not exist
import org.apache.cxf.ws.addressing.AddressingProperties; //a class (not interface)
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.EndpointReferenceUtils;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;

import tp.testwsa.server.HelloService;

public class Client { 

	private static final String HELLOSERVICE_EP_URL = "http://localhost:9091/hello"; 
    private static final String CALLBACK_EP_URL = "http://localhost:9092/callback"; 
     public static void main(String[] args) { 
    	 
         EndpointReferenceType callbackEP = startCallBackEndpoint(); 
   HelloService hello = getHelloService(); 

         setReplyDestination(hello, callbackEP); 
         System.out.println("calling syaHello ...");
         /* String res = */hello.sayHello("Developpeur Fou"); 
         System.out.println("Done (request sent)..." /* + res */); 


     } 


    private static EndpointReferenceType startCallBackEndpoint() { 

      
        EndpointImpl endpoint = (EndpointImpl) Endpoint.create(new CallbackImpl());
 	   endpoint.getFeatures().add(new WSAddressingFeature());
 	   endpoint.publish(CALLBACK_EP_URL);

        
        System.out.println("Callback service published with url=" + CALLBACK_EP_URL);
       return EndpointReferenceUtils.getEndpointReference(CALLBACK_EP_URL); //ok
       //return VersionTransformer.convertToInternal(endpoint.getEndpointReference()); //not (no more) existing

    } 

  private static void setReplyDestination(HelloService hello, EndpointReferenceType replyTo) { 

    AddressingProperties maps = new AddressingProperties(); //Impl(); 
        maps.setReplyTo(replyTo); 

        Map<String,Object> requestContext = ((BindingProvider) hello).getRequestContext(); 
         requestContext.put(CLIENT_ADDRESSING_PROPERTIES, maps); 
     } 

     private static HelloService getHelloService() { 

         QName serviceName = new QName(HelloService.NS, "HelloService"); 

         QName portName = new QName(HelloService.NS, "HelloServicePorts"); 

         /*
         ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
         factory.setServiceClass(MyService.class);
         factory.setAddress("http://acme.come/some-service");
         factory.getFeatures().add(new WSAddressingFeature());
         MyService client = (MyService) factory.create();
         */
         Service service = Service.create(serviceName,new WSAddressingFeature()); 
         service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING, HELLOSERVICE_EP_URL); 
        HelloService hello = service.getPort(portName, HelloService.class); 

         return hello; 

     } 

 } 
