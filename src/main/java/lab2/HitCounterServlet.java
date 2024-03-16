package lab2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab2/bai4")

public class HitCounterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int count = 0;
	private final Path filePath = Paths.get("C:/Temp/count.txt");

	@Override
	public void init() throws ServletException {
		System.out.println("init() chạy");
		try {
			if (Files.notExists(filePath)) {
				Files.createFile(filePath);
				Files.writeString(filePath, "0");
			} else {
				count = Integer.parseInt(Files.readString(filePath).trim());
			}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("service() chạy");
		count++;
		request.setAttribute("count", count);
		request.getRequestDispatcher("/Views/lab2/hit-counter.jsp").forward(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("destroy() chạy");
		try {
			Files.writeString(filePath, String.valueOf(count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
