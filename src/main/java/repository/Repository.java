package repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
	//JDBCURL --> 1)Dirección donde se va guardar la DB. ";" 2)Lanzamos el script que está en Resources/scripts y se llama "create.sql".
	static final String JDBCURL = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	//Este método será para insertar.
	void insert(T item);
	//Este método será para actualizar.
	void update(T item);
	//Este método será para borrar.
	void delete(T item);
	//Este método será para buscar en la DB.
	Optional<T> search(T item);
	//Este método será para listar la tabla de "<T>" con la que trabajamos.
	List<T> listAll(T item);
}
