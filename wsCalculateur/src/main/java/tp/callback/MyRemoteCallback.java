package tp.callback;

import javax.jws.Oneway;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface MyRemoteCallback {
	@Oneway
	public void notifyCorrelation(@WebParam(name="numero")int num,
			                      @WebParam(name="notifMsg")String notifMsg);
}
