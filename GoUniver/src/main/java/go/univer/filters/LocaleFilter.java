package go.univer.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {

	public static final String LOCALE_PARAM = "locale";

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) servletRequest;
		if (req.getParameter(LOCALE_PARAM) != null) {
			req.getSession().setAttribute(LOCALE_PARAM, req.getParameter(LOCALE_PARAM));
		}

		req.setCharacterEncoding("UTF-8");
		servletResponse.setCharacterEncoding("UTF-8");

		filterChain.doFilter(req, servletResponse);
	}
}
