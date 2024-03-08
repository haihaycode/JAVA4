package lab3;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/lab3/bai3")
@MultipartConfig
public class Lesson3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab3/Lesson3Form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			File dir = new File(req.getServletContext().getRealPath("/files"));
			if (!dir.exists()) {
				dir.mkdirs();
			}
			Part fileAnh = req.getPart("photo_file");
			File photo_file = new File(dir, fileAnh.getSubmittedFileName());
			fileAnh.write(photo_file.getAbsolutePath());

			Staff staff = new Staff();
			BeanUtils.populate(staff, req.getParameterMap());
			// Chuyển đổi ngày tháng từ chuỗi sang Date
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date birthday = sdf.parse(req.getParameter("birthday"));
			staff.setBirthday(birthday.toString());

			
			staff.setPhoto_file(photo_file.getName());
			req.setAttribute("bean", staff);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			req.getRequestDispatcher("/Views/lab3/Lesson3Result.jsp").forward(req, resp);
		}
	}
}
