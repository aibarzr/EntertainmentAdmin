package service;

import javax.servlet.http.HttpServletRequest;

public interface Service {
	//Se encarga de crear desde la petición que se manda del JSP.
	void createFromRequest(HttpServletRequest request);
}
