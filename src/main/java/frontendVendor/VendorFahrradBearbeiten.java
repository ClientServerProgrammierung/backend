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

        if (request.getParameter("updateBike") != null) {

            Date date = new Date();
            KostenGateway kostengateway = new KostenGateway();

            Fahrrad fahrrad = fahrradGateway.getAll().get(0);
            fahrrad.setMarke(marke);
            fahrrad.setModel(model);

            fahrradGateway.update();
            System.out.println("Fahrrad bearbeitet!");
            request.setAttribute("fahrradBearbeitet",
                    "Fahrrad mit Rahmennummer: " + rahmennummer + " wurde bearbeitet!");
            
        } else if (request.getParameter("deleteBike") != null) {
            List<Fahrrad> bikesToDelete = fahrradGateway.getFahrradByNummer(rahmennummer);
            for( Fahrrad bike: bikesToDelete) {
                fahrradGateway.deleteFahrrad(bike);
            }
            request.setAttribute("fahrradBearbeitet",
                    "Fahrrad mit Rahmennummer: " + rahmennummer + " wurde gelöscht!");
            RequestDispatcher dispatch = request.getRequestDispatcher("VendorFahrradListe.jsp");
            dispatch.forward(request, response);

        }

        new VendorFahrradBearbeiten().doGet(request, response);
    }

    // returns all Costs or all Income depending on "isIncome"
//	protected List<Kosten> getBikeBalance(String rahmennummer, KostenGateway kostengateway){
//	    KostenArtenGateway kostenArtenGateway = new KostenArtenGateway();
//	    List<Kosten> allCosts = kostengateway.getKostenByRahmennummer(rahmennummer);
//	    List<Kosten> balance = new ArrayList<Kosten>();
//	    for (Kosten kostenpunkt : allCosts) {
//	        try {            
//	            if(kostenArtenGateway.getById(kostenpunkt.getKostenArt()).getIsIncome() == isIncome) {
//                balance.add(kostenpunkt);
//              }   
//                
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//
//	    }
//	    return balance; 
//	}

}