package tp.service;

import javax.jws.WebService;

import tp.callback.CodeThreadAppelantCallBack;

@WebService(endpointInterface="tp.service.MyRemoteLogger")
public class MyRemoteLoggerImpl implements MyRemoteLogger{

	@Override
	public void logMessage(String msg) {
		System.out.println("logged message:" + msg);
		
	}

	@Override
	public void testCorrelation(int num, String requestMsg) {
		System.out.println("testCorrelation [num=" + num + "," + requestMsg + "]");
		//plus appel d'une callback via nouveau thread en differe (+5s)
		Thread t = new Thread(new CodeThreadAppelantCallBack(num, requestMsg));
		t.start();
	}

}
