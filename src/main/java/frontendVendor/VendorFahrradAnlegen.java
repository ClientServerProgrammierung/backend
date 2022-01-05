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
import gateway.KostenArtenGateway;
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
	    
	    // Models
	    Fahrrad fahrrad = new Fahrrad(rahmennummer, marke, model);
	    
	    // Gateways
        FahrradGateway fahrradGateway = new FahrradGateway();
        KostenGateway kostenGateway = new KostenGateway();
        KostenArtenGateway kostenArtenGateway = new KostenArtenGateway();
	    
	    Kosten aPreis = new Kosten();
	    
	    int kaufpreisId = 1;
	    
	    // Versuche Kostenartobjek aus Datenbank zu laden. Wenn nicht existiert erstelle
	    // neues Kostenarten - Object und füge dies der Datenbank hinzu.
	    KostenArten artAPreis;
	    
	    try {
            artAPreis = kostenArtenGateway.getById(kaufpreisId);
        } catch (Exception e) {
            System.out.print(e);
            artAPreis = new KostenArten();
            artAPreis.setId(kaufpreisId);
            artAPreis.setBeschreibung("Kauf");
            kostenArtenGateway.insertKostenArten(artAPreis);
        }
	    

	     
	    // set Anschaffungspreis - //TODO -- kosten art ist momentan als int implementiert - soll das noch geändert werden
	    aPreis.setHoehe(anschaffungspreis);
	    aPreis.setKostenArt(artAPreis.getId());
	    aPreis.setFahrradnummer(rahmennummer);
	    aPreis.setDatum(new Date());
	    
	    
	    // Neues Fahrrad und Anschaffungskosten in Datenbank einfügen
	    fahrradGateway.insertFahrrad(fahrrad);
	    kostenGateway.insertKosten(aPreis);
	    
	    
	}
}
