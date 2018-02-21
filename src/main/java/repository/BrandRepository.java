package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import connections.ConnectionH2;
import models.Brand;

public class BrandRepository implements Repository<Brand> {

	private ConnectionH2 conH2 = new ConnectionH2();

	@Override
	public void insert(Brand item) {
		// Abre la conexión con H2.
		Connection connection = conH2.open(JDBCURL);
		// Instancia el objeto para la consulta.
		PreparedStatement preparedStatement = null;
		try {
			// Creamos la consulta.
			preparedStatement = connection.prepareStatement("INSERT INTO BRANDS (name, constitution)" + "VALUES (?, ?)");
			// Le pasamos el primer parámetro (el primer interrogante)
			preparedStatement.setString(1, item.getName());
			// Le pasamos el segundo parámetro (el segundo interrogante)
			preparedStatement.setString(2, String.valueOf(item.getConstitution()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Brand item) {

	}

	@Override
	public void delete(Brand item) {

	}

	@Override
	public Optional<Brand> search(Brand item) {
		return null;
	}

	@Override
	public List<Brand> listAll(Brand item) {
		return null;
	}

}
