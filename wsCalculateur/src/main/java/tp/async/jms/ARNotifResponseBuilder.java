package tp.async.jms;

import tp.async.jms.data.Notification;
import tp.async.jms.data.AR;
import generic.async.jms.util.JmsAsyncResponseSender;
import generic.async.util.AsyncMapStorage;
import generic.async.util.AsyncResponseManager;
import generic.async.util.Command;

public class ARNotifResponseBuilder implements Command {
	
	private String key;
	
	public ARNotifResponseBuilder(){
	super();	
	}
	public ARNotifResponseBuilder(String key){
		this.key=key;
	}

	@Override
	public void execute() {
		
		try {		
			AR objAR = new AR();
			AsyncMapStorage asyncMapStorage = AsyncMapStorage.getInstance();
			if(key==null){
				key = asyncMapStorage.getFirstKey();
			}
			if(key!=null){
				Notification notifObj = (Notification) asyncMapStorage.getResquestObjectByKey(key);
				objAR.setMessage(notifObj.getMessage() + " bien recu");
				objAR.setStatus("ok");
				objAR.setRefId(notifObj.getId());
				AsyncResponseManager asyncResponseManager = new AsyncResponseManager(new JmsAsyncResponseSender());
				//asyncResponseManager.setAsyncResponseSender(new JmsAsyncResponseSender());
				asyncResponseManager.sendAsyncResponse(key, objAR);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
