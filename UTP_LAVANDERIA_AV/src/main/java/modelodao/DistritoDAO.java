package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.Conexion;
import modelo.Categoria;
import modelo.Distrito;

public class DistritoDAO extends Conexion implements IcrudDAO<Distrito>{
	private String sql_select = "SELECT iddistrito, nombredistrito FROM distritos order by iddistrito asc";

	@Override
	public void Crear(Distrito t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Actualizar(Distrito t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Distrito Obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(int id) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Distrito> ListarTodos() {
		List<Distrito> distrito = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Distrito d = new Distrito();
				d.setIddistrito(rs.getInt(1));
				d.setNomdistrito(rs.getString(2));
				distrito.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return distrito;
	}

	@Override
	public List<Distrito> Buscar(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
