package tp.testwsa.server;

import java.util.Date;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.Addressing;

import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
@org.apache.cxf.interceptor.InInterceptors (interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor" })
@WebService(endpointInterface="tp.testwsa.server.HelloService") 
@Addressing 
public class HelloServiceImpl implements HelloService { 

	 public String sayHello(String user) { 
		 System.out.println("sayHello was called in " + getClass()); 
		 String result = "Hello " + user + " @ " + new Date(); 
		 System.out.println("building result=" + result);
		 System.out.println("waiting 30s before returning result");
		 try {
			Thread.sleep(30 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println("returning result at" + new Date());
         return (result + " @ " + new Date());
     } 

   public static void main(String[] args) { 
	   /* org.apache.cxf.jaxws.EndpointImpl */
	   EndpointImpl ep = (EndpointImpl) Endpoint.create(new HelloServiceImpl());
	   ep.getFeatures().add(new WSAddressingFeature());
	   ep.publish("http://localhost:9091/hello");

	   System.out.println("server is started , waiting for request ...");
	   } 

}