package Controller;

import model.Benutzer;
import model.Fahrrad;
import model.KostenArten;

import java.time.LocalTime;
import java.util.List;
import java.util.Date;

import gateway.BenutzerGateway;
import gateway.FahrradGateway;
import gateway.KostenArtenGateway;
import gateway.LoginGateway;


public class JsfTest {
	//TODO: delete before deadline
<<<<<<< HEAD
<<<<<<< HEAD
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		
=======
	public static void main (String[] args) throws Exception {
>>>>>>> 5fa830d (Add Update method for every gateway.)
=======
	public static void main (String[] args) throws Exception {
>>>>>>> 8099fdd632ca4bd34788043aebd2d22254577d67
		
		/*

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
		

		 LoginGateway gateway = new LoginGateway();
		Benutzer benutzer = new Benutzer();
		benutzer.setVorname("nn");
		benutzer.setNachname("mm");
		benutzer.setEmail("qq@ss.de");
		benutzer.setPassword("qq");
		benutzer.setGeburtstdatum(new Date(1992, 1,1));
 		benutzer.setAdresse("irr");
	// 	gateway.insertBenutzer(benutzer);
//		List<Benutzer> list =gateway.getAllBenutzer();
    //	list.forEach(ff -> System.out.println(ff.getPassword()));
		System.out.println(gateway.IsLogged(benutzer));
		
//		BenutzerGateway gateway = new BenutzerGateway();
//		Benutzer benutzer = gateway.getBenutzerByEmail("ib@gm.de");
//		benutzer.setVorname("bra");
//		gateway.updateBenutzer(benutzer);
//		List<Benutzer> list =gateway.getAllBenutzer();
//		list.forEach(ff -> System.out.println(ff.getVorname()));
		

     

		
<<<<<<< HEAD
=======
		List<Fahrrad> list = gateway.getAll();
		list.forEach(ff -> System.out.println(ff.getModel()));*/

		FahrradGateway gateway = new FahrradGateway();
		Fahrrad fahrrad = gateway.getAll().get(0);
		fahrrad.setMarke("asfd klhjfasd jhklasfd jklhfasd klöjfsad jhklöj klöasfd ");
		gateway.update();
<<<<<<< HEAD
>>>>>>> 5fa830d (Add Update method for every gateway.)
=======
>>>>>>> 8099fdd632ca4bd34788043aebd2d22254577d67
	}
	
}
