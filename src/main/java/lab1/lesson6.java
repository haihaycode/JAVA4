package lab1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab1/bai6")
public class lesson6 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab1/formLesson6.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		double cd = Double.parseDouble(	req.getParameter("cd"));//jkdfgdw
		double cr = Double.parseDouble(	req.getParameter("cr"));
		double cv = (cd+cr)*2;
		double dt= cd*cr;
		req.setAttribute("dt", dt);
		req.setAttribute("cv", cv);
	} catch (Exception e) {
		req.setAttribute("message", "Vui lòng nhập số");
	}
	req.getRequestDispatcher("/Views/lab1/resultLesson6.jsp").forward(req, resp);
	}
}
