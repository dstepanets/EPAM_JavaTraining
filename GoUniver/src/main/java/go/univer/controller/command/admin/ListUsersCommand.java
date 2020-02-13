package go.univer.controller.command.admin;

import go.univer.controller.command.FrontCommand;
import go.univer.dao.PaginalList;
import go.univer.domain.User;
import go.univer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;

public class ListUsersCommand extends FrontCommand {
	private static final Logger LOG = LogManager.getLogger(ListUsersCommand.class);

	private final UserService userService;

	public ListUsersCommand(UserService userService) {
		this.userService = userService;
	}

/*
	@Override
	protected void processGet() throws ServletException, IOException {
//		PageProperties pageProperties = PageProperties.buildByParameters(pageNumber, itemsPerPage, DEFAULT_USERS_PER_PAGE);
//		Page<User> page = userService.findAll(pageProperties);
//		request.setAttribute("page", page);

		PaginalList<User> usersPage = userService.findAll("1");
		req.setAttribute("usersPage", usersPage);
		req.setAttribute("usersList", usersPage.getItems());

		forward("admin/users");
	}
*/

	@Override
	public void process() throws ServletException, IOException {
		String strPageNum = req.getParameter("page");
		PaginalList<User> usersPage = userService.findAll(strPageNum);
		req.setAttribute("pageNum", usersPage.getPage().getPageNum());
		req.setAttribute("itemsPerPage", usersPage.getPage().getItemsPerPage());
		req.setAttribute("maxPage", usersPage.getMaxPageNumber());
		req.setAttribute("usersList", usersPage.getItems());

		forward("views/admin/users.jsp");
	}
}
