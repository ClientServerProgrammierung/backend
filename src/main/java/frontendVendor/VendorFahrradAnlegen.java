package frontendVendor;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import gateway.FahrradGateway;
import gateway.KostenGateway;
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
	    double anschaffungspreis = Double.parseDouble(request.getParameter("anschaffungspreis"));
	    double mietpreis = Double.parseDouble(request.getParameter("mietpreis"));
	    
	    // Models
	    Fahrrad fahrrad = new Fahrrad(rahmennummer, marke, model);
	    Kosten aPreis = new Kosten();
	    Kosten mPreis = new Kosten();
	    
	    KostenArten artAPreis = new KostenArten();
	    KostenArten artMPreis = new KostenArten();
	    
	    
	    // set Anschaffungspreis - //TODO -- kosten art ist momentan als int implementiert - soll das noch geändert werden
	    aPreis.setHoehe(anschaffungspreis);
	    aPreis.setKostenArt(1);
	    
	    // set Mietpreis
        mPreis.setHoehe(mietpreis);
        mPreis.setKostenArt(1);

	    // Gateways
	    FahrradGateway fahrradGateway = new FahrradGateway();
	    KostenGateway kostenGateway = new KostenGateway();
	    
	    // Daten in Datenbank einfügen
	    fahrradGateway.insertFahrrad(fahrrad);
	    kostenGateway.insertKosten(aPreis, mPreis);
	    
	    
	}
}
