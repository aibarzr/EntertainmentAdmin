package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import connections.ConnectionH2;
import models.Console;

public class ConsoleRepository implements Repository<Console> {

	private ConnectionH2 conH2 = new ConnectionH2();
	
	@Override
	public void insert(Console item) {
		//Abre la conexión con H2.
		Connection connection = conH2.open(JDBCURL);
		//Instancia el objeto para la consulta. 
		PreparedStatement preparedStatement = null;
		try {
			//Creamos la consulta.
			preparedStatement = connection.prepareStatement("INSERT INTO CONSOLES (name, brand)" + "VALUES (?, ?)");
			//Le pasamos el primer parámetro (el primer interrogante)
			preparedStatement.setString(1, item.getName());
			//Le pasamos el segundo parámetro (el segundo interrogante)
			preparedStatement.setString(2, String.valueOf(item.getBrand()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Console item) {
		//Abre la conexión con H2.
		Connection connection = conH2.open(JDBCURL);
		//Instancia el objeto para la consulta. 
		PreparedStatement preparedStatement = null;
		try {
			//Creamos la consulta.
			preparedStatement = connection.prepareStatement("UPDATE item SET"+"name = ?, brand = ?");
			//Le pasamos el primer parámetro (el primer interrogante)
			preparedStatement.setString(1, item.getName());
			//Le pasamos el segundo parámetro (el segundo interrogante)
			preparedStatement.setString(2, Integer.toString(item.getBrand()));
			//Ejecutamos la consulta de "update".
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//Cerramos la conexión del "Execute Update".
			conH2.close(preparedStatement);
			//Cerramos la conexión inicial.
			conH2.close(connection);
		}
		
	}

	@Override
	public void delete(Console item) {
		//Abre la conexión con H2.
		Connection connection = conH2.open(JDBCURL);
		//Instancia el objeto para la consulta. 
		PreparedStatement preparedStatement = null;
		try {
			//Creamos la consulta.
			preparedStatement = connection.prepareStatement("DELETE * WHERE"+"name = ?");
			//Le pasamos el primer parámetro (el primer interrogante)
			preparedStatement.setString(1, item.getName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Console> search(Console item) {
		Console console = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = conH2.open(JDBCURL);
		
		try {
			preparedStatement = connection.prepareStatement("SELECT * FROM CONSOLE WHERE id = ?");
			preparedStatement.setString(1, Integer.toString(item.getId()));
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				console = new Console();
				console.setBrand(resultSet.getInt("brand"));
				console.setName(resultSet.getString("name"));
				console.setId(resultSet.getInt("id"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.ofNullable(item);
	}

	@Override
	public List<Console> listAll(Console item) {
		List <Console> consoles = new ArrayList<>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = conH2.open(JDBCURL);
			preparedStatement = connection.prepareStatement("SELECT * FROM CONSOLAS");
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				Console console = new Console();
				console.setBrand(resultSet.getInt("brand"));
				console.setName(resultSet.getString("name"));
				console.setId(resultSet.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return consoles;
	}

}
