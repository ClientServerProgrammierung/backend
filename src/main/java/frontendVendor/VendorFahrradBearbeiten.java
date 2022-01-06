package frontendVendor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fahrrad;
import model.Kosten;
import model.KostenArten;

import gateway.FahrradGateway;
import gateway.KostenGateway;
import gateway.KostenArtenGateway;

@WebServlet("/vendoreditbike")
public class VendorFahrradBearbeiten extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/VendorFahrradBearbeiten.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FahrradGateway fahrradGateway = new FahrradGateway();

		String marke = request.getParameter("marke");
		String model = request.getParameter("model");
		String rahmennummer = request.getParameter("rahmennummer");

		Date date = new Date();

		KostenGateway kostengateway = new KostenGateway();

		// TODO:: check ob fahrrad schon gemietet wurde

		Fahrrad fahrrad = fahrradGateway.getAll().get(0);
		fahrrad.setMarke(marke);
		fahrrad.setModel(model);

		fahrradGateway.update();
		System.out.println("Fahrrad bearbeitet!");
		request.setAttribute("fahrradBearbeitet", "Fahrrad mit Rahmennummer: " + rahmennummer + " wurde bearbeitet!");

		boolean fahrradSchonGemietet = fahrradGateway.fahrradIsGemietet(rahmennummer, date);

		new VendorFahrradBearbeiten().doGet(request, response);

	}

}