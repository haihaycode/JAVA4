package lab4;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList; // Import ArrayList
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/lab4/bai2")
public class UserServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    List<User> users;

    @Override
    public void init() throws ServletException {
        super.init();
        users = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 users = new ArrayList<>(Arrays.asList(
    	            new User("Username 1", "Password 1", true),
    	            new User("Username 2", "Password 2", false),
    	            new User("Username 3", "Password 3", true)
    	    ));
    	    req.setAttribute("message", "Quản lý người sử dụng!");
    	    req.setAttribute("form", users.get(0));
    	    req.setAttribute("items", users);
    	    req.getRequestDispatcher("/Views/lab4/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        try {
            BeanUtils.populate(user, req.getParameterMap());
            this.users.add(user);
            req.setAttribute("message", "Quản lý người sử dụng!");
    	    req.setAttribute("form", users.getLast());
            req.setAttribute("items", users);
            req.getRequestDispatcher("/Views/lab4/index.jsp").forward(req, resp);
        } catch (IllegalAccessException | InvocationTargetException e) {
            resp.getWriter().print(e.getMessage() + "<h1> error");
        }
    }
}
