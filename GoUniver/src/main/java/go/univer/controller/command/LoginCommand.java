package go.univer.controller.command;

import go.univer.entity.users.UserEntity;
import go.univer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginCommand extends FrontCommand {
	private static final Logger LOG = LogManager.getLogger(LoginCommand.class);
	private final UserService userService;

	public LoginCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void processGet() throws ServletException, IOException {
		req.getServletContext().setAttribute("loginError", null);
		forward("login");
	}

	@Override
	protected void processPost() throws ServletException, IOException {
		final String email = req.getParameter("email");
		final String password = req.getParameter("password");

		req.getServletContext().setAttribute("loginError", null);

		try (PrintWriter writer = resp.getWriter()) {
			writer.println("<p>Email: " + email + " |Pass: " + password + "<p>");
			if (userService.login(email, password).isPresent()) {
				writer.println("Login success");
				redirect("users");
			} else {
				req.getServletContext().setAttribute("loginError", "Wrong credentials :(");
				forward("login");
			}
		} catch (/*ServletException |*/ IOException e) {
			LOG.error(e);
		}

/*			final String email = (String) req.getAttribute("email");
			final String password = (String) req.getAttribute("password");

			final Optional<UserEntity> user = userService.login(email, password);

			if (user.isPresent()) {
				final HttpSession session = req.getSession();
				session.setAttribute("user", user.get());
//			return "view/profile.jsp";
*/
	}

}
