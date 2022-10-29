package modelodao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import modelo.Prenda;

public class PrendaDAO extends Conexion implements IcrudDAO<Prenda>, IcontarDAO<Prenda>{
	private String sql_select = "SELECT idprenda, nomprenda, descprenda, pesoprenda, cantidadprenda FROM prendas";
	private String sql_insert = "INSERT INTO prendas(idprenda, nomprenda, descprenda, pesoprenda, cantidadprenda) VALUES (nextval('sqprendas'),?,?,?,?)";
	//CONTAR TODOS
	private String sql_countall = "SELECT count(*) FROM prendas";
	@Override
	public void Crear(Prenda p) {
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_insert);
			stmt.setString(1, p.getNomprenda());
			stmt.setString(2, p.getDescprenda());
			stmt.setDouble(3, p.getPesoprenda());
			stmt.setInt(4, p.getCantidadprenda());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int Actualizar(Prenda t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Prenda Obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Eliminar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prenda> ListarTodos() {
		List<Prenda> prenda = new ArrayList<>();
		Connection con = obtenerConexion();
		try {
			PreparedStatement stmt = con.prepareStatement(sql_select);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Prenda p = new Prenda();
				p.setIdprenda(rs.getInt(1));
				p.setNomprenda(rs.getString(2));
				p.setDescprenda(rs.getString(3));
				p.setPesoprenda(rs.getDouble(4));
				p.setCantidadprenda(rs.getInt(5));
				prenda.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prenda;
	}

	@Override
	public List<Prenda> Buscar(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}
	//
	@Override
	public int ContarTodos() {
		Connection con = obtenerConexion();
		int cantidad = 0;
		try {
			PreparedStatement stmt = con.prepareStatement(sql_countall);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			cantidad = rs.getInt(1);
			return cantidad;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cantidad;
	}

}
