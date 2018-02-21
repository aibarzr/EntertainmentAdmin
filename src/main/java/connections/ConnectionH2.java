package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionH2 implements ConnectionManager {

	@Override
	public Connection open(String jdbcUrl) {
		Connection con = null;
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection(jdbcUrl + ";INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'", "sa",
					"");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public Connection execute(Connection con, String sql) {
		PreparedStatement prepState;
		try {
			prepState = con.prepareStatement(sql);
			prepState.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(Statement stm) {
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void close(PreparedStatement prepstm) {
		if (prepstm != null) {
			try {
				prepstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
