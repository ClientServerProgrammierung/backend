package web.customer;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/LoginRegister.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String stockEmail = "contact@test.de";
		String stockPassword = "123";
		
		if (!email.equals(stockEmail)) {
			request.setAttribute("error", "email");
			doGet(request, response);
		} else if (!password.equals(stockPassword)) {
			request.setAttribute("error", "password");
			doGet(request, response);
		} else if (email.equals(stockEmail) && password.equals(stockPassword)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vendorbikelist");
			dispatcher.forward(request, response);
		}
	}

}