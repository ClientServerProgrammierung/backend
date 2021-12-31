package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gateway.FahrradGateway;
import model.Fahrrad;

@WebServlet("/fahrradAuswahl")
public class FahrradAuswahl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		FahrradGateway gateway = new FahrradGateway();

		List<Fahrrad> fahrradListe = gateway.getAll();

		request.setAttribute("fahrradListe", fahrradListe);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/FahrradAuswahl.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}