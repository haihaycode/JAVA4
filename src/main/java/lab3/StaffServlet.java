package lab3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab3/bai2")
public class StaffServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab3/Lesson2Form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			Staff staff = new Staff();
			BeanUtils.populate(staff, req.getParameterMap());
			// Chuyển đổi ngày tháng từ chuỗi sang Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date birthday = sdf.parse(req.getParameter("birthday"));
			staff.setBirthday(birthday.toString());

			// Tiếp tục đặt các thuộc tính khác của đối tượng Staff
		

			req.setAttribute("bean", staff);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		req.getRequestDispatcher("/Views/lab3/Lesson2Result.jsp").forward(req, resp);
	}
}
