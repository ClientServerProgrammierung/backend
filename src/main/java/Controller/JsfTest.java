package Controller;

import model.Benutzer;
import model.Fahrrad;
import model.Kosten;
import model.KostenArten;

import java.time.LocalTime;
import java.util.List;
import java.util.Date;

import gateway.BenutzerGateway;
import gateway.FahrradGateway;
import gateway.KostenArtenGateway;
import gateway.KostenGateway;
import gateway.LoginGateway;


public class JsfTest {
	//TODO: delete before deadline
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {


		KostenGateway gw = new KostenGateway();
		List<Kosten> kosten = gw.getKostenByRahmennummer("123132");
		
	}
	
}
