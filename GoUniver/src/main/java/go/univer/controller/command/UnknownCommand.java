package go.univer.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnknownCommand extends FrontCommand {
	@Override
	public void process() throws ServletException, IOException {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//		forward("error");
	}
}
