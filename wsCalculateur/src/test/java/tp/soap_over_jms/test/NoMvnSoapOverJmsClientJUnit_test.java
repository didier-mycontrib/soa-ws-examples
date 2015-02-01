package tp.soap_over_jms.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tp.service.Calculateur;

/*
 * test calculateur (soap over jms)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/clientCxfSpringConf.xml"})
public class NoMvnSoapOverJmsClientJUnit_test {
	
	@Autowired
	private Calculateur calculateurProxy;
	
	@Test
	public void testCalculateur(){
		System.out.println("5.2+6.3=" + calculateurProxy.addition(5.2, 6.3));
	}
	

}
