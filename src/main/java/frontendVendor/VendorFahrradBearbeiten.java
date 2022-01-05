package frontendVendor;

import java.io.IOException;



import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gateway.FahrradGateway;
import gateway.KostenGateway;



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

		String rahmennummer = request.getParameter("rahmennummer");
		Date date = new Date();

		KostenGateway kostengateway = new KostenGateway();

		// TODO:: check ob fahrrad schon gemietet wurde
		FahrradGateway fahrradGateway = new FahrradGateway();
		boolean fahrradSchonGemietet = fahrradGateway.fahrradIsGemietet(rahmennummer, date);

	
		new VendorFahrradBearbeiten().doGet(request, response);

	}

}