package tp.async.jms;

import generic.async.jms.util.GenericJmsToJavaListener;
import generic.async.util.AsyncContext;
import generic.async.util.AsyncMapStorage;
import generic.async.util.GenericCommandThread;
import tp.async.jms.data.Notification;


public class NotificationListener extends GenericJmsToJavaListener<Notification> {

	@Override
	public void OnJavaMessage(Notification msg,AsyncContext asyncContex) {
		System.out.println("notification recue via jms:" + msg.toString());
		String key = AsyncMapStorage.getInstance().storeRequestObjectWithAsyncContext(msg, asyncContex);
		/* thread pour traitement différé sans interaction utilisateur : */
		GenericCommandThread.executeCommandAfterDelay(10 * 1000, new ARNotifResponseBuilder(key));
	}
	
	
}
