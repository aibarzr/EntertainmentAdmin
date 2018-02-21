package service;

import javax.servlet.http.HttpServletRequest;

import assembler.ConsoleAssembler;
import models.Console;
import repository.ConsoleRepository;

public class ConsoleService implements Service{
	//Creamos el "ensamblador" del objeto "Console".
	ConsoleAssembler consoleAssembler = new ConsoleAssembler();
	//Creamos el repositorio del objeto "Console".
	ConsoleRepository consoleRepository = new ConsoleRepository();
	
	@Override
	public void createFromRequest(HttpServletRequest request) {
		//Creamos el objeto consola con los parametros pasados en el formulario de inserción.
		Console console = consoleAssembler.createConsole(request);
		//Primero revisamos que no exista ninguna consola igual a la que se pasa des del JSP.
		if(!consoleRepository.search(console).isPresent()) {
			//En caso de que no exista insertamos la consola en la DB.
			consoleRepository.insert(console);
		} else {
			//En caso de que exista, simplemente actualizamos los datos.
			consoleRepository.update(console);
		}
		
	}

}
