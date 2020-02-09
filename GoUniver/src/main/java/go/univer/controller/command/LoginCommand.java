package go.univer.controller.command;

import go.univer.entity.users.UserEntity;
import go.univer.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand extends FrontCommand {
	private final UserService userService;

	public LoginCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void process() {
		final String email = (String) req.getAttribute("email");
		final String password = (String) req.getAttribute("password");

		final Optional<UserEntity> user = userService.login(email, password);

		if (user.isPresent()) {
			final HttpSession session = req.getSession();
			session.setAttribute("user", user.get());
//			return "view/profile.jsp";
		}
//		return "view/login.jsp";
	}
}
