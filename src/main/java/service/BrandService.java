package service;

import javax.servlet.http.HttpServletRequest;

import assembler.BrandAssembler;
import models.Brand;
import repository.BrandRepository;

public class BrandService implements Service {

	// Creamos el "ensamblador" del objeto "Console".
	BrandAssembler brandAssembler = new BrandAssembler();
	// Creamos el repositorio del objeto "Console".
	BrandRepository brandRepository = new BrandRepository();

	@Override
	public void createFromRequest(HttpServletRequest request) {
		// Creamos el objeto consola con los parametros pasados en el formulario de
		// inserción.
		Brand brand = brandAssembler.createBrand(request);
		// Primero revisamos que no exista ninguna consola igual a la que se pasa des
		// del JSP.
		if (!brandRepository.search(brand).isPresent()) {
			// En caso de que no exista insertamos la consola en la DB.
			brandRepository.insert(brand);
		} else {
			// En caso de que exista, simplemente actualizamos los datos.
			brandRepository.update(brand);
		}

	}

}
