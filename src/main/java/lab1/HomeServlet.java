package lab1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab1/bai3")
public class HomeServlet extends HttpServlet {
	//BÀI 3 + 4
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		req.setAttribute("message", "Chào thế giới Servlet/Jsp");
		
		req.getRequestDispatcher("/Views/lab1/index.jsp").forward(req, resp);
		
	}
	
	
}
