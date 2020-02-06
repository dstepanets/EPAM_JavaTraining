package go.univer.controller;

import go.univer.injector.AppInjector;
import go.univer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final Logger LOG = LogManager.getLogger(LoginServlet.class);
	private final UserService userService = AppInjector.getInstance().getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getServletContext().setAttribute("loginError", false);
		req.getRequestDispatcher(req.getContextPath() + "/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
//		req.getServletContext().setAttribute("loginError", null);
		try (PrintWriter writer = resp.getWriter()) {
			writer.println("<p>Email: " + email + " |Pass: " + password + "<p>");
			if (userService.login(email, password).isPresent()) {
				writer.println("Login success");
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("views/users.jsp");
//				dispatcher.forward(req, resp);
//				req.getRequestDispatcher(req.getContextPath() + "/users").forward(req, resp);
				resp.sendRedirect(req.getContextPath() + "/users");
			} else {
				writer.println("<p align='center'>Wrong credentials</p>");
				resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
				req.getServletContext().setAttribute("loginError", true);
//				req.setAttribute("loginError", "Wrong credentials");
//				req.getRequestDispatcher("/login").include(req, resp);
			}
		} catch (/*ServletException |*/ IOException e) {
			LOG.error(e);
		}
	}


	//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		final User user = (User) req.getSession().getAttribute("user");
//		final Role role = new ArrayList<>(user.getRoles()).get(0);
//		//Better to use filters
//		if (role != Role.ADMIN) {
//			req.getRequestDispatcher("view/not_admin.jsp").forward(req, resp);
//		}
//		final List<User> users = userService.findAll();
//		req.setAttribute("users", users);
//
//		req.getRequestDispatcher("view/users.jsp").forward(req, resp);
//	}

}
