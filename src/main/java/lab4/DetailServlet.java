package lab4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab4/bai3")
public class DetailServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Item item = new Item("Nokia 2020", "https://cdn2.cellphones.com.vn/x/media/catalog/product/n/o/nokia-105-4g-pro_1__1.png", 500, 0.1);
		req.setAttribute("item", item);
		req.getRequestDispatcher("/Views/lab4/detail.jsp").forward(req, resp);
	}
}
