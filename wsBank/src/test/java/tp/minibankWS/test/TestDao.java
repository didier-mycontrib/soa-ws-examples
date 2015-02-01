package tp.minibankWS.test;

import java.util.Collection;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tp.miniBankWS.dao.FraisDossierDao;
import tp.miniBankWS.dao.TauxInteretDao;
import tp.miniBankWS.entity.PlageFraisDossier;
import tp.miniBankWS.entity.PlageTauxInteret;

public class TestDao extends TestCase {
	// test unitaire avec JUnit
	public void testFraisDossierDao()
	{
		ApplicationContext context =
			new ClassPathXmlApplicationContext("/springContext.xml");
		BeanFactory bf = (BeanFactory) context;
		FraisDossierDao fraisDossierDao = (FraisDossierDao) 
		       bf.getBean("fraisDossierDaoJpa" /*id*/);
		Collection<PlageFraisDossier> listePlages = fraisDossierDao.getPlagesFraisDossier();
		for(PlageFraisDossier p :listePlages)
			System.out.println(p);
		PlageFraisDossier plage = fraisDossierDao.getPlageFraisDossierSelonMontant(200);
		System.out.println("pour 200 -->" +plage);
		assertTrue(plage.getNum_plage()==1);
		plage = fraisDossierDao.getPlageFraisDossierSelonMontant(50000);
		System.out.println("pour 50000 -->" +plage);
		assertTrue(plage.getNum_plage()==2);
		plage = fraisDossierDao.getPlageFraisDossierSelonMontant(200000);
		System.out.println("pour 200000 -->" +plage);
		assertTrue(plage.getNum_plage()==3);
		
	}
	
	public void testTauxInteretDao()
	{
		ApplicationContext context =
			new ClassPathXmlApplicationContext("/springContext.xml");
		BeanFactory bf = (BeanFactory) context;
		TauxInteretDao tauxInteretDao = (TauxInteretDao) 
		       bf.getBean("tauxInteretDaoJpa" /*id*/);
		Collection<PlageTauxInteret> listePlages = tauxInteretDao.getPlagesTauxInteret();
		for(PlageTauxInteret p :listePlages)
			System.out.println(p);
		PlageTauxInteret plage = tauxInteretDao.getPlageTauxInteretSelonDuree(6);
		System.out.println("pour 6 mois -->" +plage);
		assertTrue(plage.getNum_plage()==1);
		plage = tauxInteretDao.getPlageTauxInteretSelonDuree(24);
		System.out.println("pour 24 mois = 2 ans -->" +plage);
		assertTrue(plage.getNum_plage()==2);
		plage = tauxInteretDao.getPlageTauxInteretSelonDuree(120);
		System.out.println("pour 120 mois = 10 ans -->" +plage);
		assertTrue(plage.getNum_plage()==3);
		
	}
	
	public static void main(String[] args) {
		TestDao testDao = new TestDao();
		testDao.testFraisDossierDao();
		testDao.testTauxInteretDao();
	}

}
