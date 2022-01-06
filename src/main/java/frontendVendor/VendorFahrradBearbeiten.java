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

		String rahmennummer = request.getParameter("rahmennummer");
		Date date = new Date();

		KostenGateway kostengateway = new KostenGateway();

		// TODO:: check ob fahrrad schon gemietet wurde
		FahrradGateway fahrradGateway = new FahrradGateway();
		boolean fahrradSchonGemietet = fahrradGateway.fahrradIsGemietet(rahmennummer, date);
		
		getBikeBalance(rahmennummer, kostengateway, true);

	
		new VendorFahrradBearbeiten().doGet(request, response);

	}
	
	// returns all Costs or all Income depending on "isIncome"
	protected List<Kosten> getBikeBalance(String rahmennummer, KostenGateway kostengateway, boolean isIncome){
	    KostenArtenGateway kostenArtenGateway = new KostenArtenGateway();
	    List<Kosten> allCosts = kostengateway.getKostenByRahmennummer(rahmennummer);
	    List<Kosten> balance = new ArrayList<Kosten>();
	    for (Kosten kostenpunkt : allCosts) {
	          if(kostenArtenGateway.getById(kostenpunkt.getKostenArt()).getIsIncome() == isIncome) {
	              balance.add(kostenpunkt);
	            }   
	    }
	    return balance; 
	    
	}

	
 

}