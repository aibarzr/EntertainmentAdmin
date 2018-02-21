package assembler;

import javax.servlet.http.HttpServletRequest;

import models.Console;

public class ConsoleAssembler {
	public Console createConsole(HttpServletRequest request) {
		Console console = new Console();
		console.setName(request.getParameter("name"));
		console.setBrand(Integer.parseInt(request.getParameter("brand")));
		return console;
	}
}
