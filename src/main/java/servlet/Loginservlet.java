package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email.equals("hari@gmail.com") && (password.equals("123"))) {
			writer.println(email.substring(0,4)+"welcome to login");
			HttpSession session=request.getSession();
			session.setAttribute("name",email.substring(0,4));
		}
		else {
			writer.println("invalid login  ");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}

	

}
