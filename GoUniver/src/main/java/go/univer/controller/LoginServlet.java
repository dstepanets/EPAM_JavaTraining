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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		try (PrintWriter writer = resp.getWriter()) {
			writer.println("Email: " + email + " |Pass: " + password + "");
			if (email.equals("111")) {
//			if (userService.login(email, password)) {
				req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
			} else {
				writer.println("<p align='center'>Wrong credentials</p>");
				req.getRequestDispatcher("/index.jsp").include(req,resp);
			}
		} catch (ServletException | IOException e) {
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
