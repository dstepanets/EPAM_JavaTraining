package go.univer.command;

import go.univer.entity.users.UserEntity;
import go.univer.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class RegisterCommand implements Command {
	private final UserService userService;

	public RegisterCommand(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//Session
		final String email = (String) request.getAttribute("email");
		final String firstName = (String) request.getAttribute("firstName");
		final String lastName = (String) request.getAttribute("lastName");
		final String password1 = (String) request.getAttribute("password1");
		final String password2 = (String) request.getAttribute("password2");

		if (!Objects.equals(password1, password2)) {
			return "view/register.jsp";
		}

		final UserEntity userEntity = UserEntity.builder()
				.withEmail(email)
				.withFirstName(firstName)
				.withLastName(lastName)
				.withPassword(password1)
				.build();

		userService.register(userEntity);

		return "view/login.jsp";
	}
}
