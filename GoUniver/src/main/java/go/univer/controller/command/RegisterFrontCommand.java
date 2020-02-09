package go.univer.controller.command;

import go.univer.entity.users.UserEntity;
import go.univer.service.UserService;

import java.util.Objects;

public class RegisterFrontCommand extends FrontCommand {
	private final UserService userService;

	public RegisterFrontCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void process() {
		//Session
		final String email = (String) req.getAttribute("email");
		final String firstName = (String) req.getAttribute("firstName");
		final String lastName = (String) req.getAttribute("lastName");
		final String password1 = (String) req.getAttribute("password1");
		final String password2 = (String) req.getAttribute("password2");

		if (!Objects.equals(password1, password2)) {
//			return "view/register.jsp";
		}

		final UserEntity userEntity = UserEntity.builder()
				.withEmail(email)
				.withFirstName(firstName)
				.withLastName(lastName)
				.withPassword(password1)
				.build();

		userService.register(userEntity);

//		return "view/login.jsp";
	}
}
