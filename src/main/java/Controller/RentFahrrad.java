package Controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import model.Fahrrad;


@Path("service")
public class RentFahrrad  {
	@SuppressWarnings("unused")
	@Context
	private UriInfo uriInfo;

	public RentFahrrad() {
	}

//	@GET
//	@Produces("application/xml")
//	public String getXml() {
//// TODO return proper representation object
//		throw new UnsupportedOperationException();
//	}

	@PUT
	@Consumes("application/xml")
	public void putXml(String content) {
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sagHtml() {

//         String url = "jdbc:postgresql:/localhost:5432/shop";
//		 String user = "postgres";
//		 String password ="postgres";
//		 Connection  connection = null;
//		  Statement statement = null;
//	
//			try{
//			   connection = DriverManager.getConnection(url, user, password);
//				if (connection != null) {
//					System.out.println("success");
//				}
//				
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//
	System.out.print("rentfahrrad controller!!");
		
	return "<html><body><h1>Hallo!</h1></body></html>";
	}

}
