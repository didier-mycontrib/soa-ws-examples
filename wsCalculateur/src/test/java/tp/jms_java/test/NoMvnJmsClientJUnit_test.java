package tp.jms_java.test;

import generic.jms.util.JmsQueueSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * test calculateur (soap over jms)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/clientCxfSpringConf.xml"})
public class NoMvnJmsClientJUnit_test {
	
	@Autowired
	//private MyJmsQueueSender myJmsQueueSender;
	private JmsQueueSender myJmsQueueSender;
	
	@Test
	public void testSendNotifiction(){
		String messageText = "<notification><id>1</id><subject>sujetXY</subject><message>messageAB</message></notification>";
		myJmsQueueSender.sendTxtMessageWithDestinationNameCorrIdAndReplyDestinationName(
				messageText, "queue.notification","123", "queue.AR");
		System.out.println("suite *** ");
	}
	

}
