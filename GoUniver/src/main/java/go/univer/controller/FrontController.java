package go.univer.controller;

import go.univer.controller.command.FrontCommand;
import go.univer.controller.command.HomeCommand;
import go.univer.controller.command.UnknownCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontCommand frontCommand = getCommand(request);
		frontCommand.init(getServletContext(), request, response);
		frontCommand.process();
	}

	private FrontCommand getCommand(HttpServletRequest request) {
		try {
			Class type = Class.forName(String.format("go.univer.controller.command.%sCommand", request.getParameter("command")));
			return (FrontCommand) type.asSubclass(FrontCommand.class).newInstance();
		} catch (Exception e) {
			return new HomeCommand();
//			return new UnknownCommand();
		}
	}
}
