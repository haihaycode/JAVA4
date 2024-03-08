package lab4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab4/bai5")
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Item> items = new ArrayList<>(Arrays.asList(new Item("iPhone 12",
				"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1200, 0.1),
				new Item("iPhone 13",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1300,
						0.1),
				new Item("iPhone 14",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1400,
						0.1),
				new Item("iPhone 15",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1500,
						0.1),
				new Item("iPhone 16",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1600,
						0.1),
				new Item("iPhone 17",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1700,
						0.1),
				new Item("iPhone 18",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1800,
						0.1),
				new Item("iPhone 19",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 1900,
						0.1),
				new Item("iPhone 20",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 2000,
						0.1),
				new Item("iPhone 21",
						"https://cdn.hoanghamobile.com/i/preview/Uploads/2020/11/06/apple-iphone-12-mini-5.png", 2100,
						0.1)));
		req.setAttribute("items", items);
		if (req.getParameter("name") != null) {
			for (Item item : items) {
				if (item.getName().equals(req.getParameter("name"))) {
					req.setAttribute("item", item);
					req.getRequestDispatcher("/Views/lab4/detail.jsp").forward(req, resp);
					return;
				}
			}
		}
		req.getRequestDispatcher("/Views/lab4/list.jsp").forward(req, resp);

	}
}
