package web.customer;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gateway.BenutzerGateway;
import gateway.FahrradGateway;
import gateway.KostenGateway;
import model.Benutzer;
import model.Kosten;

@WebServlet("/fahrradMieten")
public class FahrradMieten extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FahrradMieten.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rahmennummer = request.getParameter("rahmennummer");
		Integer dauer = Integer.valueOf(request.getParameter("dauer"));
		Date date = new Date();
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		BenutzerGateway benutzerGateway = new BenutzerGateway();
		KostenGateway kostengateway = new KostenGateway();

		// boolean ob fahrrad schon gemietet wurde
		FahrradGateway fahrradGateway = new FahrradGateway();
		boolean fahrradSchonGemietet = fahrradGateway.fahrradIsGemietet(rahmennummer, date);

		// benutzer anlegen
		Benutzer benutzer = new Benutzer();
		benutzer.setEmail(email);
		benutzer.setNachname(nachname);
		benutzer.setVorname(vorname);
		benutzer.setAdresse(adresse);
		benutzer.setGeburtstdatum(new Date());
		benutzerGateway.insertBenutzer(benutzer);
		Benutzer nutzer = benutzerGateway.getBenutzerByEmail(email);

		System.out.println(nutzer);
		if (!fahrradSchonGemietet && nutzer != null) {
			// Fahrred wird gemietet
			Kosten kosten = new Kosten();
			kosten.setDatum(date);
			kosten.setBenutzer(nutzer.getId());
			kosten.setDauer(dauer);
			kosten.setFahrradnummer(rahmennummer);
			kosten.setKostenArt(3);
			kosten.setHoehe(5 * dauer);
			kostengateway.insertKosten(kosten);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(formatter.format(date));

			System.out.println("Fahrrad gemietet !");
			request.setAttribute("mietenErfolgreich",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " wurde Erfolgreich gemietet !");
		} else {
			// Fahrrad wird nicht gemietet
			System.out.println("Fahrrad nicht gemietet !");
			request.setAttribute("mietenFehlgeschlagen",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " konnte nich gemietet werden !");
		}
		new FahrradAuswahl().doGet(request, response);
	}

}