package lab3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab3/bai4")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = CookieUtils.get("username", req);
		String password = CookieUtils.get("password", req);

		req.setAttribute("username", username);
		req.setAttribute("password", password);
		req.getRequestDispatcher("/Views/lab3/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		String message = "";
		if (!username.equals("poly")) {
			message = "Sai tên đăng nhập !";
		} else if (password.length() < 6) {
			message = "Mật khẩu sai !";
		} else {
			int hours = (remember == null) ? 0 : 30 * 24; // 0 = xóa
			CookieUtils.add("username", username, hours, resp);
			CookieUtils.add("password", password, hours, resp);
			message = "Đăng Nhập thành công !";
			
		}
		req.setAttribute("message", message);
		req.getRequestDispatcher("/Views/lab3/login.jsp").forward(req, resp);
	}

}
