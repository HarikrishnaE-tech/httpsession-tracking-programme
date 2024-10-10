package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Logoutservlet")
public class Logoutservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer=response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		
		HttpSession session=request.getSession(false);
		if(session!=null) {
			
			session.invalidate();;
			writer.print("logout successfully");
		}
		else {
			writer.println(" you are not logged in");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
	}

	

}
