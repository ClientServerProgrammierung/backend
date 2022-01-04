package frontendVendor;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gateway.FahrradGateway;
import model.Fahrrad;
import model.Kosten;
import model.KostenArten;

@WebServlet("/vendorcreatebike")
public class VendorFahrradAnlegen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/VendorFahrradAnlegen.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    String rahmennummer = request.getParameter("rahmennummer");
	    String marke = request.getParameter("marke");
	    String model = request.getParameter("model");
	    double anschaffungspreis = request.getParameter("anschaffungspreis");
	    String mietpreis = request.getParameter("mietpreis");
	    
	    // Fahrrad - Model
	    Fahrrad fahrrad = new Fahrrad(rahmennummer, marke, model);
	    
	    Kosten asPreis = new Kosten();
	    asPreis.setHoehe(anschaffungspreis);
	    asPreis.setKostenArt();
	    
        Kosten mPreis = new Kosten();
        
        
	    
	    // Gateway
	    FahrradGateway fahrradGateway = new FahrradGateway();
	    
	    // fahrrad in Datenbank hinzufügen
	    fahrradGateway.insertFahrrad(fahrrad);
	    
	    
	}

}
