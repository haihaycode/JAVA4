package lab1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab1/caculator")
public class CaculatorServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab1/caculator.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			double a = Double.parseDouble(req.getParameter("a"));
			double b = Double.parseDouble(req.getParameter("b"));
			String x = req.getParameter("action");
			double rs = 0;
			switch (x) {
			case "+": {
				rs = a + b;
				break;
			}
			case "-": {
				rs = a - b;
				break;
			}
			case "*": {
				rs = a * b;
				break;
			}
			case "/": {
				rs = a / b;
				break;
			}
			}

			req.setAttribute("rs", rs);
			req.getRequestDispatcher("/Views/lab1/caculatorResult.jsp").forward(req, resp);
		} catch (Exception e) {
			resp.getWriter().print("Vui long nhap so !");
		}

	}
}
