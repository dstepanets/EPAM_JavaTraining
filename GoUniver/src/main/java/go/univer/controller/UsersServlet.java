package go.univer.controller;

import go.univer.domain.User;
import go.univer.injector.AppInjector;
import go.univer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {
	private static final Logger LOG = LogManager.getLogger(UsersServlet.class);
	private final UserService userService = AppInjector.getInstance().getUserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		execute(req, resp);
	}

	private void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.getRequestDispatcher("/views/users.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			LOG.error(e);
		}
	}

/*	private void execute(HttpServletRequest req, HttpServletResponse resp) {
		String pageNum = req.getParameter("page");
		long totalUser = userService.getUsersCount();
		List<User> users = userService.findAll(pageNum);

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		try (PrintWriter writer = resp.getWriter()) {
			writer.println("e: " + email + " |p: " + password + "");
			writer.println("<h3>Users List</h3>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

}
