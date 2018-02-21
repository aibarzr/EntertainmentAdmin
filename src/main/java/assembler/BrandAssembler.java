package assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import models.Brand;

public class BrandAssembler {
	public Brand createBrand(HttpServletRequest request) {
		Brand brand = new Brand();
		brand.setConstitution(Date.valueOf(request.getParameter("constitution")));
		brand.setName(request.getParameter("name"));
		return brand ;
		
	}
}
