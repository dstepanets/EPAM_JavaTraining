package go.univer.controller.command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand {
	protected ServletContext context;
	protected HttpServletRequest req;
	protected HttpServletResponse resp;

	public void init(ServletContext servletContext, HttpServletRequest servletRequest, HttpServletResponse servletResponse) {
		this.context = servletContext;
		this.req = servletRequest;
		this.resp = servletResponse;
	}

	public abstract void process() throws ServletException, IOException;

	protected void forward(String target) throws ServletException, IOException {
		target = String.format("/views/%s.jsp", target);
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(req, resp);
	}
}
