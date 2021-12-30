package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fahrrad;

@WebServlet("/fahrradAuswahl")
public class FahrradAuswahl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// --------------- Mit .jsp file ----------------------------------------------
		// https://stackoverflow.com/questions/10594919/passing-value-from-servlet-to-html
		
		Fahrrad fahrrad1 = new Fahrrad();
		fahrrad1.setMarke("Abus");
		fahrrad1.setModel("D34D2");
		fahrrad1.setRahmennummer("1234678");
		
		Fahrrad fahrrad2 = new Fahrrad();
		fahrrad2.setMarke("Ballistol");
		fahrrad2.setModel("D314D2");
		fahrrad2.setRahmennummer("12674678");
		
		Fahrrad fahrrad3 = new Fahrrad();
		fahrrad3.setMarke("Atranvelo");
		fahrrad3.setModel("D314D2");
		fahrrad3.setRahmennummer("12674678");
		

		Fahrrad fahrrad4 = new Fahrrad();
		fahrrad4.setMarke("Basil");
		fahrrad4.setModel("D314D2");
		fahrrad4.setRahmennummer("12674678");
		
		Fahrrad fahrrad5 = new Fahrrad();
		fahrrad5.setMarke("Pegasus");
		fahrrad5.setModel("D314D2");
		fahrrad5.setRahmennummer("12674678");
		
		ArrayList<Fahrrad> fahrradListe = new ArrayList<Fahrrad>();
		fahrradListe.add(fahrrad1);
		fahrradListe.add(fahrrad2);	
		fahrradListe.add(fahrrad3);	
		fahrradListe.add(fahrrad4);	
		fahrradListe.add(fahrrad5);	
		
		request.setAttribute("fahrradListe", fahrradListe);
		
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FahrradAuswahl.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}