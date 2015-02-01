package tp.callback;

import javax.jws.WebService;

@WebService(endpointInterface="tp.callback.MyRemoteCallback")
public class MyRemoteCallbackImpl implements MyRemoteCallback {

	@Override
	public void notifyCorrelation(int num, String notifMsg) {
		System.out.println("temp java implementation to generate wsdl");
		
	}

}
