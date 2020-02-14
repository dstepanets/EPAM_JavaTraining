package go.univer.controller.command;

import go.univer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;

public class LoginCommand extends FrontCommand {
	private static final Logger LOG = LogManager.getLogger(LoginCommand.class);
	private final UserService userService;

	public LoginCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void processGet() throws ServletException, IOException {
		req.getServletContext().setAttribute("loginError", false);
		forward("views/login.jsp");
	}

	@Override
	protected void processPost() throws ServletException, IOException {
		final String email = req.getParameter("email");
		final String password = req.getParameter("password");

		req.getServletContext().setAttribute("loginError", false);

		if (userService.login(email, password).isPresent()) {
			redirect("admin/users");
		} else {
			req.getServletContext().setAttribute("loginError", true);
			forward("views/login.jsp");
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
