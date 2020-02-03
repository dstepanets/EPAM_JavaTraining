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

public class UsersServlet extends HttpServlet {
	private static final Logger LOG = LogManager.getLogger(UsersServlet.class);
	private final UserService userService = AppInjector.getInstance().getUserService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		try (PrintWriter writer = resp.getWriter()) {
			writer.println("e: " + email + " |p: " + password + "");
		}

	}

}
