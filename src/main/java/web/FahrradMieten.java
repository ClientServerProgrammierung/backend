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

import gateway.FahrradGateway;
import model.Benutzer;
import model.Fahrrad;
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

		String marke = request.getParameter("marke");
		String model = request.getParameter("model");
		String rahmennummer = request.getParameter("rahmennummer");
		String name = request.getParameter("name");

		Kosten kosten = new Kosten();

		Date date = new Date();
		kosten.setDatum(new Date());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(formatter.format(date));
		System.out.println("Fahrrad gemietet !");

		doGet(request, response);
	}

}