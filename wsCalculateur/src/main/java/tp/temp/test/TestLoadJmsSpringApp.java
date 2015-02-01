package tp.temp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class TestLoadJmsSpringApp {

	public static void main(String[] args) {
		
		/*WebApplicationContext parentCtx  =
				WebApplicationContextUtils.getWebApplicationContext(servletContext);*/
		ApplicationContext parentCtx  = new ClassPathXmlApplicationContext("springContext.xml");
		ApplicationContext springJmsContext =
				new ClassPathXmlApplicationContext(
				new String[] {"jmsSpringConf.xml","soap-over-jms-endpointSpringConf.xml"},parentCtx);
		if(springJmsContext.containsBean("jmsConnectionFactory"))
			System.out.println("jmsConnectionFactory is ok");
		if(springJmsContext.containsBean("myJmsListener"))
			System.out.println("myJmsListener is ready");
		if(springJmsContext.containsBean("serviceCalculateur_soap_over_jms_endPoint"))
			System.out.println("serviceCalculateur_soap_over_jms_endPoint is ready");
	}

}
