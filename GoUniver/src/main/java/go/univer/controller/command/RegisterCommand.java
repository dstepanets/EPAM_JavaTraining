package go.univer.controller.command;

import go.univer.domain.User;
import go.univer.service.UserService;
import go.univer.service.validator.ValidationException;

import javax.servlet.ServletException;
import java.io.IOException;

public class RegisterCommand extends FrontCommand {
	private final UserService userService;

	public RegisterCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void processGet() throws ServletException, IOException {
		req.getServletContext().setAttribute("registerError", false);
		forward("views/register.jsp");
	}

	@Override
	protected void processPost() throws ServletException, IOException {
		req.getServletContext().setAttribute("registerError", false);

		//Session
		final String email = req.getParameter("email");
		final String firstName = req.getParameter("firstName");
		final String lastName = req.getParameter("lastName");
		final String password1 = req.getParameter("password1");
		final String password2 = req.getParameter("password2");

		if (!password1.equals(password2)) {
			req.getServletContext().setAttribute("registerError", true);
			req.getServletContext().setAttribute("exception", "Passwords doesn't match");
			forward("views/register.jsp");
			return;
		}

		User user = User.builder()
				.withEmail(email)
				.withFirstName(firstName)
				.withLastName(lastName)
				.withPassword(password1)
				.withRole(User.Role.STUDENT)
				.build();

		try {
			user = userService.register(user);
			forward("views/login.jsp");
		} catch (ValidationException e) {
			req.getServletContext().setAttribute("registerError", true);
			req.getServletContext().setAttribute("exception", e.getMessage());
			forward("views/register.jsp");
		}


//		return "view/login.jsp";
	}

}
