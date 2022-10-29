package conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Conexion {
	public Connection obtenerConexion() {
		Connection con=null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:jboss/datasources/utplavanderiaDS");
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void cerrarConexion(Statement stmt, Connection con) throws SQLException {
		stmt.close();
		con.close();
	}
}
