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

import gateway.FahrradGateway;
import model.Fahrrad;

@WebServlet("/vendorbikelist")
public class VendorFahrradListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Date currentDate = new Date();
		FahrradGateway gateway = new FahrradGateway();

		//TODO FOR LOOP LÖSCHEN DA WIR ALLE FAHRRÄDER ANZEIGEN WOLLEN!
		List<Fahrrad> fahrradListe = gateway.getAll();
		
//		List<Fahrrad> fahrradListeVerfuegbar = new ArrayList<>();
//
//		for (Fahrrad fahrrad : fahrradListe) {
//			// Fahrräder die schon gemietet sind, werden nicht aufgelistet.
//
//				fahrradListeVerfuegbar.add(fahrrad);
//			
//		}

		request.setAttribute("fahrradListe", fahrradListe);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/VendorFahrradListe.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}