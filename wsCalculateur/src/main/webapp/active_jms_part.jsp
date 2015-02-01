<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@page import=" org.springframework.context.ApplicationContext" %>
<%@page import="org.springframework.web.context.WebApplicationContext" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>active_jms_part</title>
</head>
<body>
<pre>      *****************************************
	Une partie de cette application comporte des services 
	que l'on peut invoquer via JMS.
	Cependant la configuration Spring liée à JMS lève pleins
	d'exceptions si l'agent activeMq n'est pas accessible au bout
	de l'url suivante : tcp://localhost:61616  .
	On peut facilement vérifier que le broker de ActiveMQ est bien démarré via la
	<a href="http://localhost:8161/admin/">console web de activeMQ (agent JMS)</a>.
	-------------------------------------------------------------
	Au démarrage de l'application, seule la partie HTTP , SOAP-OVER-HTTP
	est chargée/activée.
	--------------------------------------------------------------
	il faut cliquer sur le lien hypertexte suivant pour
	activer/charger la partie "JMS et SOAP-OVER-JMS" de cette application web
	             ************************
</pre>
	<a href="active_jms_part.jsp?active_jms=true">activer la partie JMS</a>. <br/>
	<%
	String active_jms = request.getParameter("active_jms");
	if(active_jms != null && active_jms.equals("true")){
		
		ApplicationContext springJmsContext = (ClassPathXmlApplicationContext) application.getAttribute("springJmsContext");
		if(springJmsContext==null){
			
			WebApplicationContext parentCtx = WebApplicationContextUtils.getWebApplicationContext(application);
			
			springJmsContext=new ClassPathXmlApplicationContext(
				new String[] {"jmsSpringConf.xml","soap-over-jms-endpointSpringConf.xml"},parentCtx);
				application.setAttribute("springJmsContext",springJmsContext);
		}
		if(springJmsContext.containsBean("jmsConnectionFactory"))
			out.println("<i>jmsConnectionFactory is ok</i><br/>");
		if(springJmsContext.containsBean("myJmsNotifListener"))
			out.println("<i>myJmsNotifListener is ready</i><br/>");
		if(springJmsContext.containsBean("myJmsDemandeCongesListener"))
			out.println("<i>myJmsDemandeCongesListener is ready</i><br/>");
		if(springJmsContext.containsBean("serviceCalculateur_soap_over_jms_endPoint"))
			out.println("<i>serviceCalculateur_soap_over_jms_endPoint is ready</i><br/>");
		
		%>
		 <br/>
		 <b>la partie JMS est activée </b>
		 <br/>
		 <a href="index.html">revenir vers la page d'accueil</a>
		 <br/>
		<% 
	}
	%>
</body>
</html>