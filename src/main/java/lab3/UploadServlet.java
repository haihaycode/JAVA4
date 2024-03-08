package lab3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/lab3/bai1")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Views/lab3/form.jsp").forward(req, resp);// forward về 1 trang

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	       
	        //Thực hiện việc tạo một đối tượng File mới để đại diện cho một thư mục trong ứng dụng web
	        File dir = new File(req.getServletContext().getRealPath("/files"));
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }
	        
	        // Xử lý file ảnh
	        Part fileAnh = req.getPart("photo_file");
	        File photo_file = new File(dir, fileAnh.getSubmittedFileName());
	        fileAnh.write(photo_file.getAbsolutePath());
	        
	        // Xử lý file tài liệu
	        Part filedoc = req.getPart("doc_file");
	        File doc_file = new File(dir, filedoc.getSubmittedFileName());
	        filedoc.write(doc_file.getAbsolutePath());
	        
	        
	        req.setAttribute("img", photo_file); 
	        req.setAttribute("doc", doc_file); 
	        
	        req.getRequestDispatcher("/Views/lab3/result.jsp").forward(req, resp);
	    } catch (Exception e) {
	        // Xử lý ngoại lệ nếu có
	        e.printStackTrace();
	        // Hoặc xử lý ngoại lệ theo cách thích hợp
	        // Ví dụ: resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    }
	}

}
