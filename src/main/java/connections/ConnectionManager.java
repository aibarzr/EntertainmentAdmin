package connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface ConnectionManager {

	public Connection open(String jdbcUrl);

	public Connection execute(Connection con, String sql);

	public void close(Connection con);
	public void close(Statement stm);
	public void close(PreparedStatement prepstm);
}
