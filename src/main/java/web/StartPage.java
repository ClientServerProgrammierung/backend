package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class StartPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* --------------- ohne jsp Seite ----------------------------------------------
		 * 
		 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
		 * String fname = request.getParameter("firstName"); String lname =
		 * request.getParameter("lastName"); String email =
		 * request.getParameter("email"); String age = request.getParameter("age");
		 * out.println("<center> Your Name is " + fname + " " + lname +
		 * "<br> Your E-mail is " + email + "<br> You are " + age +
		 * " years old !</center>");
		 * 
		 * 
		 */
			
		// --------------- Mit .jsp file ----------------------------------------------
		// https://stackoverflow.com/questions/10594919/passing-value-from-servlet-to-html
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/StartPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
