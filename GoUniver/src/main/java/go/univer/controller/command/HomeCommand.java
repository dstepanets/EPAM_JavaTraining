package go.univer.controller.command;

import javax.servlet.ServletException;
import java.io.IOException;

public class HomeCommand extends FrontCommand {
	@Override
	public void process() throws ServletException, IOException {
		forward("home");
//		redirect("home");
	}
}
