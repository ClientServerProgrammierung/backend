package Controller;

import model.Fahrrad;
import model.KostenArten;

import java.util.List;
import gateway.FahrradGateway;
import gateway.KostenArtenGateway;


public class JsfTest {
	//TODO: delete before deadline
	public static void main (String[] args) {
		
		

//		FahrradGateway gateway = new FahrradGateway();
//		Fahrrad fahrrad = new Fahrrad();
//		fahrrad.setRahmennummer("1293509");
//		fahrrad.setMarke("Serious");
//		fahrrad.setModel("Rockville 27.5\" schwarz/grau");
//		
//		gateway.insertFahrrad(fahrrad);
//		Fahrrad f = new Fahrrad();
//		f.setRahmennummer("1534045");
//		f.setMarke("GIANT");
//		f.setModel("Talon 4 schwarz");
//		
//		gateway.insertFahrrad(fahrrad, f);
//		
//		
//		List<Fahrrad> list = gateway.getAll();
//		list.forEach(ff -> System.out.println(ff.getModel()));
		
		KostenArtenGateway gateway = new KostenArtenGateway();
		List<KostenArten> list =gateway.getAllKostenArten();
		list.forEach(ff -> System.out.println(ff.getBeschreibung()));
		
	}
	
}
