package Controller;

import model.Fahrrad;

import java.util.List;
import gateway.FahrradGateway;


public class JsfTest {
	//TODO: delete before deadline
	public static void main (String[] args) throws Exception {
		
		/*

		FahrradGateway gateway = new FahrradGateway();
		Fahrrad fahrrad = new Fahrrad();
		fahrrad.setRahmennummer("1293509");
		fahrrad.setMarke("Serious");
		fahrrad.setModel("Rockville 27.5\" schwarz/grau");
		
		gateway.insertFahrrad(fahrrad);
		Fahrrad f = new Fahrrad();
		f.setRahmennummer("1534045");
		f.setMarke("GIANT");
		f.setModel("Talon 4 schwarz");
		
		gateway.insertFahrrad(fahrrad, f);
		
		
		List<Fahrrad> list = gateway.getAll();
		list.forEach(ff -> System.out.println(ff.getModel()));*/

		FahrradGateway gateway = new FahrradGateway();
		Fahrrad fahrrad = gateway.getAll().get(0);
		fahrrad.setMarke("asfd klhjfasd jhklasfd jklhfasd kl�jfsad jhkl�j kl�asfd ");
		gateway.update();
	}
	
}
