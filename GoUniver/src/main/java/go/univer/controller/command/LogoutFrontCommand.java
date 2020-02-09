package go.univer.controller.command;

import javax.servlet.http.HttpSession;

public class LogoutFrontCommand extends FrontCommand {
	@Override
	public void process() {
		final HttpSession session = req.getSession();
		session.invalidate();

//		return "view/home.jsp";
	}
}
