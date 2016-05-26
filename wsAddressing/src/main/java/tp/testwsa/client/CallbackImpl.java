package tp.testwsa.client;


import java.util.Date;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;
 @WebService(endpointInterface="tp.testwsa.client.Callback")
@org.apache.cxf.interceptor.InInterceptors (interceptors = {"org.apache.cxf.interceptor.LoggingInInterceptor" }) 

 public class CallbackImpl implements Callback { 

 @Oneway 
 public void callBack(@WebParam(name="response")String callbackMessage) { 
 System.out.println("Received callback message " + callbackMessage ); 
 System.out.println("timestamp: " + new Date());
 } 

 } 
