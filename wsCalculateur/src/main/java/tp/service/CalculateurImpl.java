package tp.service;

import javax.jws.WebService;

@WebService(endpointInterface="tp.service.Calculateur")
public class CalculateurImpl implements Calculateur {

	@Override
	public double addition(double a, double b) {
		double res=a+b;
		System.out.println("addition("+a+","+b+")="+res);
		return res;
	}

	@Override
	public double multiplication(double a, double b) {
		double res=a*b;
		System.out.println("multiplication("+a+","+b+")="+res);
		return res;
	}

	@Override
	public String getAuteur() {
		return "didier defrance";
	}

}
