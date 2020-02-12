package go.univer.controller.command;

import go.univer.controller.FrontController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
	private static final Logger LOG = LogManager.getLogger(FrontCommand.class);
	public static final String ERROR_PAGE = "error";

	protected ServletContext context;
	protected HttpServletRequest req;
	protected HttpServletResponse resp;

	public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		this.context = servletContext;
		this.req = servletRequest;
		this.resp = servletResponse;
	}

	public void process() throws ServletException, IOException {
		if (req.getMethod().equals("GET")) {
			processGet();
		} else if (req.getMethod().equals("POST")){
			processPost();
		} else {
			forward(ERROR_PAGE);
		}
	}

	protected void processGet() throws ServletException, IOException {
		forward(ERROR_PAGE);
	}

	protected void processPost() throws ServletException, IOException {
		forward(ERROR_PAGE);
	}

	protected void forward(String target) throws ServletException, IOException {
		target = String.format("%s/views/%s.jsp", req.getContextPath(), target);
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(req, resp);
	}

	protected void redirect(String target) throws IOException {
		target = String.format("%s/views/%s.jsp", req.getContextPath(), target);
		resp.sendRedirect(target);
	}


}
