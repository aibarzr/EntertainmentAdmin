package assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import models.Videogame;

public class VideogameAssembler {

	public Videogame createVideogame(HttpServletRequest request) {
		Videogame vg = new Videogame();
		vg.setName(request.getParameter("name"));
		vg.setLaunch(Date.valueOf(request.getParameter("launch")));
		vg.setPEGI(request.getParameter("PEGI"));
		return vg;
	}
}
