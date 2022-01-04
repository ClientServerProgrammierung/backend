package web;

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
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

		// TODO:: check ob fahrrad schon gemietet wurde
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
		List<Benutzer> benutzerList = benutzerGateway.getBenutzerByEmail(email);

		System.out.println(benutzerList.isEmpty());
		if (!fahrradSchonGemietet && !benutzerList.isEmpty()) {
			// Fahrred wird gemietet
			Kosten kosten = new Kosten();
			kosten.setDatum(date);
			kosten.setBenutzer(benutzerList.get(0).getId());
			kosten.setDauer(dauer);
			kosten.setFahrradnummer(rahmennummer);
			// TODO:: Kostenart in Kosten hinzufügen
			kosten.setKostenArt(0);
			kosten.setHoehe(5 * dauer);
			kostengateway.insertKosten(kosten);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println(formatter.format(date));

			System.out.println("Fahrrad gemietet !");
			request.setAttribute("mietenErfolgreich",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " wurde Erfolgreich gemietet !");
			// doGet(request, response);
		} else {
			// Fahrrad wird nicht gemietet
			System.out.println("Fahrrad nicht gemietet !");
			request.setAttribute("mietenFehlgeschlagen",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " konnte nich gemietet werden !");
			// doGet(request, response);
		}

//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FahrradAuswahl.jsp");
//		dispatcher.forward(request, response);
		new FahrradAuswahl().doGet(request, response);

	}

}