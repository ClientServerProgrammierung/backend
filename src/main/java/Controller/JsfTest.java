package Controller;

import model.Fahrrad;

import java.util.List;
import gateway.FahrradGateway;


public class JsfTest {
	//TODO: delete before deadline
	public static void main (String[] args) {
		
		

		FahrradGateway gateway = new FahrradGateway();
		Fahrrad fahrrad = new Fahrrad();
		fahrrad.setRahmennummer("2");
		fahrrad.setMarke("fads�kljasdjlk�f");
		fahrrad.setModel("asdfjlk�ljk�dfsa");
		
		gateway.insertFahrrad(fahrrad);
		Fahrrad f = new Fahrrad();
		f.setRahmennummer("3");
		f.setMarke("fads�kljasdjlk�f");
		f.setModel("asdfjlk�ljk�dfsa");
		
		gateway.insertFahrrad(fahrrad, f);
		
		
		List<Fahrrad> list = gateway.getAll();
		list.forEach(ff -> System.out.println(ff.getModel()));
	}
	
}
