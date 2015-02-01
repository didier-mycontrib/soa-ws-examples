package tp.async.jms;

import generic.async.jms.util.JmsAsyncResponseSender;
import generic.async.util.AsyncMapStorage;
import generic.async.util.AsyncResponseManager;
import generic.async.util.Command;
import tp.async.jms.data.AcceptationOuRefus;
import tp.async.jms.data.DemandeConges;

public class AcceptationOuRefusCongesResponseBuilder implements Command {
	
	private String key;
	
	public AcceptationOuRefusCongesResponseBuilder(){
	super();	
	}
	public AcceptationOuRefusCongesResponseBuilder(String key){
		this.key=key;
	}

	@Override
	public void execute() {
		
		try {		
			AcceptationOuRefus objAcceptRef = new AcceptationOuRefus();
			AsyncMapStorage asyncMapStorage = AsyncMapStorage.getInstance();
			if(key==null){
				key = asyncMapStorage.getFirstKey();
			}
			if(key!=null){
				DemandeConges demandeCongesObj = (DemandeConges) asyncMapStorage.getResquestObjectByKey(key);
				boolean acceptation = false;
				if((demandeCongesObj.getNumDemande()%2)==0)
					acceptation=true;
				objAcceptRef.setAcceptation(acceptation);
				objAcceptRef.setRefDemande(String.valueOf(demandeCongesObj.getNumDemande()));
				objAcceptRef.setTexte("demandes de id=num_impair refusees , demandes de id=num_pair acceptees");
				AsyncResponseManager asyncResponseManager = new AsyncResponseManager(new JmsAsyncResponseSender());
				//asyncResponseManager.setAsyncResponseSender(new JmsAsyncResponseSender());
				asyncResponseManager.sendAsyncResponse(key, objAcceptRef);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
