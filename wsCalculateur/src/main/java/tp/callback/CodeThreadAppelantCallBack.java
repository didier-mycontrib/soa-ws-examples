package tp.callback;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class CodeThreadAppelantCallBack implements Runnable{
	
	private int numero;
	private String requestMsg;

	public CodeThreadAppelantCallBack(){
		
	}
	
	public CodeThreadAppelantCallBack(int numero,String requestMsg){
		this.numero= numero;
		this.requestMsg = requestMsg;
	}
	
	@Override
	public void run() {
		System.out.println("" + numero +" s de pause");
		try {
			Thread.sleep(numero * 1000); //ex 5000 ms = 5s
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("appel de la callback");
		
		QName SERVICE_NAME = new QName("http://callback.tp/", "MyRemoteCallbackImplService");
		QName PORT_NAME = new QName("http://callback.tp/", "MyRemoteCallbackImplPort");
		Service service = Service.create(SERVICE_NAME);		//javax.xml.ws.Service
		// Endpoint Address		
		String endpointAddress = "http://localhost:8080/ode/processes/axb/myRemoteCallback";
		//if(requestMsg.substring(0,1).equals("*"))
			//endpointAddress = "http://localhost:8181/cxf/myRemoteCallback";
		// Add a port to the Service , javax.xml.ws.soap.SOAPBinding
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,endpointAddress);

		MyRemoteCallback callbackProxy = (MyRemoteCallback)
				service.getPort(PORT_NAME, MyRemoteCallback.class);

		callbackProxy.notifyCorrelation(this.numero, "notification: message recu=" + this.requestMsg);
	}

}
