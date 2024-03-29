package web.vendor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fahrrad;

import gateway.FahrradGateway;
import gateway.KostenGateway;

@WebServlet("/vendoreditbike")
public class VendorFahrradUebersicht extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/VendorFahrradUebersicht.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FahrradGateway fahrradGateway = new FahrradGateway();

		String marke = request.getParameter("marke");
		String model = request.getParameter("model");
		String rahmennummer = request.getParameter("rahmennummer");

		if (request.getParameter("updateBike") != null) {

			Date date = new Date();

			Fahrrad fahrrad = fahrradGateway.getAll().get(0);
			fahrrad.setMarke(marke);
			fahrrad.setModel(model);

			fahrradGateway.update();
			System.out.println("Fahrrad bearbeitet!");
			request.setAttribute("fahrradBearbeitet",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " wurde bearbeitet!");
			
			new VendorFahrradUebersicht().doGet(request, response);

		} else if (request.getParameter("deleteBike") != null) {
			List<Fahrrad> bikesToDelete = fahrradGateway.getFahrradByNummer(rahmennummer);
			for (Fahrrad bike : bikesToDelete) {
				fahrradGateway.deleteFahrrad(bike);
			}
			request.setAttribute("fahrradBearbeitet",
					"Fahrrad mit Rahmennummer: " + rahmennummer + " wurde gel�scht!");
			new VendorFahrradListe().doGet(request, response);
		}
	}
}