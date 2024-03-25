package lab5;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({

		"/account/sign-up", "/account/sign-in", "/account/sign-out", "/account/forgot-password",
		"/account/change-password", "/account/edit-profile"

})
public class AccountServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		if (uri.contains("/account/sign-in")) {// đăng nhập
			this.doSignIn(req, resp);
		} else if (uri.contains("/account/sign-up")) {// đăng ký
			this.doSignUp(req, resp);
		} else if (uri.contains("/account/sign-out")) {// đăng xuất
			req.getSession().removeAttribute("user");
			resp.sendRedirect("/LABS/account/sign-in");
		} else if (uri.contains("/account/edit-profile")) {
			this.doEditProfile(req, resp);
		} else if (uri.contains("/account/forgot-password")) {
			this.doForgotPassword(req, resp);
		}
	}

	private void doSignIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			user = new User();
			try {
				user = JpaProgram.find(req.getParameter("ID").trim());
				if (!user.getPassword().equals(req.getParameter("password"))) {
					req.setAttribute("mess", "Sai mật khẩu!");
				} else {
					req.setAttribute("mess", "Đăng nhập thành công!");
					req.getSession().setAttribute("user", user);

				}
			} catch (Exception e) {
				req.setAttribute("mess", "Sai tên đăng nhập!");
			}
		}
		req.getRequestDispatcher("/Views/lab5/sign-in.jsp").forward(req, resp);
	}

	private void doSignUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {
			String mess = "";
			try {
				user = new User();
				BeanUtils.populate(user, req.getParameterMap());
				mess = JpaProgram.create(user);
			} catch (IllegalAccessException | InvocationTargetException e) {
				mess = e.getMessage();
			}
			req.setAttribute("mess", mess);
		}
		req.getRequestDispatcher("/Views/lab5/sign-up.jsp").forward(req, resp);
	}

	private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user = new User();
		user = (User) req.getSession().getAttribute("user");
		if (user != null) {
			if (req.getMethod().equalsIgnoreCase("POST")) {
				try {
					BeanUtils.populate(user, req.getParameterMap());
					JpaProgram.update(user);
					req.setAttribute("mess", "Cập nhật thành công");
				} catch (IllegalAccessException | InvocationTargetException e) {
					req.setAttribute("mess", "Cập nhật thất bại");
				}
			}
			req.getRequestDispatcher("/Views/lab5/edit-profile.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("/LABS/account/sign-in");
		}

	}

	private void doForgotPassword(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("POST")) {

		}
		req.getRequestDispatcher("/Views/lab5/forgot-password.jsp").forward(req, resp);
	}
}
