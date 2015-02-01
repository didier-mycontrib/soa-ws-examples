package tp.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService()
//@SOAPBinding(style = SOAPBinding.Style.RPC)// document/literal par defaut
public interface Calculateur {
	public double addition(@WebParam(name="a")double a,
			               @WebParam(name="b")double b);
	public double multiplication(@WebParam(name="a")double a,
            					@WebParam(name="b")double b);
	
	public String getAuteur();

}
