package tp.async.jms;

import generic.async.jms.util.GenericJmsToJavaListener;
import generic.async.util.AsyncContext;
import generic.async.util.AsyncMapStorage;
import generic.async.util.GenericCommandThread;
import tp.async.jms.data.DemandeConges;


public class DemandeCongesListener extends GenericJmsToJavaListener<DemandeConges> {

	@Override
	public void OnJavaMessage(DemandeConges msg,AsyncContext asyncContex) {
		System.out.println("demande de conges recue via jms:" + msg.toString());
		String key = AsyncMapStorage.getInstance().storeRequestObjectWithAsyncContext(msg, asyncContex);
		/* thread pour traitement différé sans interaction utilisateur : */
		GenericCommandThread.executeCommandAfterDelay(10 * 1000, new AcceptationOuRefusCongesResponseBuilder(key));
	}
	
	
}
