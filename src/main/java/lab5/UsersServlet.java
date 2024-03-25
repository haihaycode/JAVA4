package lab5;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/user/index", "/user/edit/id/*", "/user/create", "/user/update", "/user/delete" })
public class UsersServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		List<User> lists= JpaProgram.findAll(); 
		int totalPages = lists.size();
		
		int itemsPerPage = 10;//tổng user / trang
		int Pages = totalPages / itemsPerPage; // tính được tổng số page
		if (totalPages % itemsPerPage != 0) {//tăng 1 đơn vị nếu ra số lẽ
			Pages++;
		}
		
		req.setAttribute("pageCount", req.getParameter("page") == null ? 0 : req.getParameter("page"));//lấy trang hiện tại , nếu không có thì cho =0
		req.setAttribute("Pages", Pages);//gửi tông page sang jsp
		
		List<User> list = JpaProgram.findPage(Integer.parseInt(req.getAttribute("pageCount").toString()), itemsPerPage); // truy vấn trang hiện tại với tổng page

		
		

		if (uri.contains("/user/index")) {
			req.setAttribute("list", list);
			req.getRequestDispatcher("/Views/lab5/Users.jsp").forward(req, resp);
		} else if (uri.contains("/user/edit/id")) {
			String[] parts = uri.split("/");
			String id = parts[parts.length - 1];
			user = JpaProgram.find(id.trim());
			System.out.println(id);
			req.setAttribute("user", user);
			req.setAttribute("list", list);
			req.getRequestDispatcher("/Views/lab5/Users.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		HttpSession session = req.getSession();

		if (uri.contains("/user/create")) {
			user = new User();
			try {
				BeanUtils.populate(user, req.getParameterMap());
				String mess = JpaProgram.create(user);
				session.setMaxInactiveInterval(5);
				session.setAttribute("mess", mess);
				resp.sendRedirect("/LABS/user/index");

			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println(e.getMessage());
			}
		} else if (uri.contains("/user/update")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				String mess = JpaProgram.update(user);
				session.setMaxInactiveInterval(5);
				session.setAttribute("mess", mess);
				resp.sendRedirect("/LABS/user/index");
			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println(e.getMessage());
			}
		} else if (uri.contains("/user/delete")) {
			try {
				BeanUtils.populate(user, req.getParameterMap());
				String mess = JpaProgram.delete(user);
				session.setMaxInactiveInterval(5);
				session.setAttribute("mess", mess);
				resp.sendRedirect("/LABS/user/index");
			} catch (IllegalAccessException | InvocationTargetException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
