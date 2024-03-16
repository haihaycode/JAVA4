package lab2;

import java.io.IOException;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab2/bai3")
public class DangKyLesson3 extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab2/Lesson3.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] hobbies = req.getParameterValues("hobbies");//lấy 1 mảng các tham số về 
		System.out.println(Arrays.toString(hobbies)); // in ra theo dạng String
		req.getRequestDispatcher("/Views/lab2/Lesson3Result.jsp").forward(req, resp);
	}
}
