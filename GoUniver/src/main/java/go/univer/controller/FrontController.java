package go.univer.controller;

import go.univer.controller.command.FrontCommand;
import go.univer.controller.command.UnknownCommand;
import go.univer.injector.AppInjector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FrontController extends HttpServlet {
	private static final Logger LOG = LogManager.getLogger(FrontController.class);

	private final Map<String, FrontCommand> commands = AppInjector.getInstance().getCommands();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getCommand(req, resp).process();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getCommand(req, resp).process();
	}

	private FrontCommand getCommand(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String reqURI = req.getRequestURI();
		LOG.debug(String.format("Requested URI: %s", reqURI));
		FrontCommand frontCommand = commands.get(reqURI);
		if (frontCommand == null) {
			frontCommand = new UnknownCommand();
		}
		frontCommand.init(getServletContext(), req, resp);
		return frontCommand;
	}
}
