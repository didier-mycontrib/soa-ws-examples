package tp.service;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MyRemoteLogger {
	@Oneway
	public void logMessage(@WebParam(name="msg")String msg);
	
	@Oneway
	public void testCorrelation(@WebParam(name="numero")int num,
			                    @WebParam(name="requestMsg")String requestMsg);
}
