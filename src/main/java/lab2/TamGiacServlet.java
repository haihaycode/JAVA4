package lab2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/lab2/bai1", "/lab2/bai1/chu-vi", "/lab2/bai1/dien-tich" })
public class TamGiacServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab2/tamGiac.jsp").forward(req, resp);

	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("tính toán");
		String message = "";
		try {
			double a = Double.parseDouble(req.getParameter("a"));
			double b = Double.parseDouble(req.getParameter("b"));
			double c = Double.parseDouble(req.getParameter("c"));
			if ((a + b > c) && (a + c > b) && (b + c > a)) {
				double chuVi = (a + b + c);
				String uri = req.getRequestURI();
				if (uri.contains("dien-tich")) {
					double dienTich = Math.sqrt(chuVi * (a + b - c) * (a + c - b) * (b + c - a)) / 4;
					message = "Diện tích của tam giác là " + dienTich;
				} else {
					message = "Chu vi của tam giác là " + chuVi;
				}

			} else {
				message = "Không thỏa mãn các cạnh của một tam giác!";
			}
		} catch (Exception e) {
			message = "Vui lòng nhập đầy đủ các thông tin và đúng định dạng !";
		} finally {
			req.setAttribute("message", message);
			req.getRequestDispatcher("/Views/lab2/tamGiac.jsp").forward(req, resp);
		}
	}

}
