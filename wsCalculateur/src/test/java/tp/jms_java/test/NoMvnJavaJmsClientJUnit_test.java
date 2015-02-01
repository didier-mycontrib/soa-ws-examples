package tp.jms_java.test;

import generic.async.jms.util.GenericJavaJmsClient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.async.jms.data.DemandeConges;
import tp.async.jms.data.Notification;

/*
 * test calculateur (soap over jms)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/clientCxfSpringConf.xml"})
public class NoMvnJavaJmsClientJUnit_test {
	
	@Autowired
	private GenericJavaJmsClient genericJavaJmsClient;
	
	@Test
	public void testSendNotifiction(){
		Notification notifObj = new Notification();
		notifObj.setId("1");
		notifObj.setMessage("messageABC");
		notifObj.setSubject("sujetXYZ");
		genericJavaJmsClient.sendJavaMessageViaJms(notifObj, "queue.notification","456", "queue.AR");
		System.out.println("suite *** ");
	}
	
	@Test
	public void testSendDemandeConges(){
		DemandeConges demandeCongesObj = new DemandeConges();
		demandeCongesObj.setNumDemande(1L);
		demandeCongesObj.setPrenom("Alain");
		demandeCongesObj.setNom("Therieur");
		demandeCongesObj.setIdEmploye("emp1245");
		demandeCongesObj.setDateDebut("2013-12-23");
		demandeCongesObj.setDateDebut("2014-01-03");
		genericJavaJmsClient.sendJavaMessageViaJms(demandeCongesObj, "queue.demandeConges","456", "queue.reponseConges");
		System.out.println("suite *** ");
	}
	

}
